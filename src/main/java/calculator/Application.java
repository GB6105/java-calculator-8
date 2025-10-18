package calculator;

import calculator.controller.Controller;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Controller controller = new Controller();
            controller.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
