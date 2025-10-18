package calculator.controller;

import calculator.domain.Calculator;
import calculator.util.Parser;
import calculator.util.Validator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Controller {
    public void run() {
        InputView inputView = new InputView();
        String input = inputView.inputString();
        Validator validator = new Validator();
        validator.validateInput(input);
        Parser parser = new Parser();
        List<Integer> numbers = parser.parseString(input);
        Calculator calculator = new Calculator();
        int result = calculator.calculate(numbers);
        OutputView outputView = new OutputView();
        outputView.printResult(result);
    }
}
