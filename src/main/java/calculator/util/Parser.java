package calculator.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseString(String input) {
        String delimiters = ",|:";

        if (input.startsWith("//")) {
            int customDelimiterIdx = input.indexOf("\n");
            if (customDelimiterIdx == -1) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
            }
            String customDelimiter = input.substring(2, customDelimiterIdx);
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
            }
            input = input.substring(customDelimiterIdx + 1);
            delimiters += "|" + customDelimiter;

        }
        System.out.println(delimiters);
        String[] tokens;
        try {
            tokens = input.split(delimiters);
            for (String s : tokens) {
                System.out.println(s);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR);
        }
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            try {
                result.add(Integer.parseInt(token));

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다." + token);
            }
        }
        return result;
    }
}
