package calculator;

import calculator.controller.Controller;
import calculator.util.ErrorMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
        }
    }
}
