package calculator;

import calculator.util.Parser;
import calculator.util.Validator;
import calculator.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void input_test() {
        assertSimpleTest(() -> {
            run("문자열 입력");
            InputView inputView = new InputView();
            String input = inputView.inputString();
            assertThat(input).isEqualTo("문자열 입력");
        });
    }

    @Test
    void validator_test() {
        assertSimpleTest(() -> {
            run("1,2:3");
            InputView inputView = new InputView();
            String input = inputView.inputString();
            Validator validator = new Validator();
            boolean validateResult = validator.validateInput(input);
            assertThat(validateResult).isTrue();
        });
    }

    @Test
    void parser_test() {
        assertSimpleTest(() -> {
            String testInput = "1,2:3";
            Parser parser = new Parser();
            List<Integer> result = parser.parseString(testInput);
            assertThat(result).containsExactly(1, 2, 3);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
