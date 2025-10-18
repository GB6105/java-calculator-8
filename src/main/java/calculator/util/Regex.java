package calculator.util;

import java.util.regex.Pattern;

public class Regex {
    public static final String NORMAL_CASE = "^\\d+(?:[,:]\\d+)*$";
    public static final String CUSTOM_CASE = "^//(.+?)\\r?\\n([0-9]+(?:[^0-9\\r\\n]+[0-9]+)*)$";
}
