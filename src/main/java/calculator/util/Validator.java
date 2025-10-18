package calculator.util;

public class Validator {
    public boolean validateString(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        if (!input.matches(Regex.NORMAL_CASE) && !input.matches(Regex.CUSTOM_CASE)) {
            return false;
        }
        return true;
    }
}
