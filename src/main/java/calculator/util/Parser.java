package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseString(String input) {
        String delimiters = ",|:";

        if (input.startsWith("//")) {
            int customDelimiterIdx = input.indexOf("\\n");
            if (customDelimiterIdx == -1) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
            }
            String customDelimiter = input.substring(2, customDelimiterIdx);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
            }
            input = input.substring(customDelimiterIdx + 2);
            delimiters += "|" + customDelimiter;

        }
        String[] tokens;
        try {
            tokens = input.split(delimiters);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
        }
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            try {
                int value = Integer.parseInt(token);
                checkValue(value);
                result.add(value);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다." + token);
            }
        }
        return result;
    }

    private void checkValue(int value) {
        if (value <= 0) { // 등호 넣어주기
            throw new IllegalArgumentException(ErrorMessage.INTEGER_RANGE_ERROR);
        }
    }
}
