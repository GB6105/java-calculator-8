package calculator.util;

import java.util.random.RandomGenerator;
import java.util.regex.Pattern;

public class Validator {
    public boolean validateInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        input = input.trim();
        input = input.replace("\\n", "\n");
        if (Pattern.matches(Regex.NORMAL_CASE, input)) {
            return true;
        }

        if (Pattern.matches(Regex.CUSTOM_CASE, input)) {
            return true;
        }

        return false;
    }
}
