package Chapter1.Question5;

public class Solution {
    public static String compress(String inputStr) {
        char prev = '\0';
        int count = 0;
        StringBuilder retStr = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            if (prev == '\0') {
                prev = ch;
                count = 1;
            } else if (prev == ch) {
                count += 1;
            } else {
                String appendStr = String.format("%c%d", prev, count);
                retStr.append(appendStr);
                prev = ch;
                count = 1;
            }
        }
        String appendStr = String.format("%c%d", prev, count);
        retStr.append(appendStr);
        String result = retStr.toString();
        return result.length() < inputStr.length() ? result : inputStr;
    }
}
