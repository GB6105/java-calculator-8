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
            System.out.println("위치 파악" + customDelimiter);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
            }
            input = input.substring(customDelimiterIdx + 2);
            System.out.println("문자열만 " + input);
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
                if (value < 0) {
                    throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR + "음수는 불가능합니다");
                }
                result.add(value);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다." + token);
            }
        }
        return result;
    }
}
