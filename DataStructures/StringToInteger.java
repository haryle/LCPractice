public class StringToInteger {
    public static void main(String[] argv) {
        StringToInteger solution = new StringToInteger();
//        System.out.println(solution.myAtoi("+42"));
//        System.out.println(solution.myAtoi("-42"));
        System.out.println(solution.myAtoi("       -42"));
        System.out.println(solution.myAtoi("words and 987"));

        System.out.println(solution.myAtoi("002 "));
        System.out.println(solution.myAtoi("+42 asd"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("2147483648"));

    }

    public int myAtoi(String s) {
        int index = 0;
        String stripped = s.strip();
        int length = stripped.length();
        StringBuilder result = new StringBuilder();
        boolean expectSign = true;
        boolean positive = true;
        boolean leadingZero = true;
        while (index < length) {
            char ch = stripped.charAt(index);
            if (expectSign) {
                if (ch == '-')
                    positive = false;
                else if (ch == '+') {
                } else
                    index--;
                expectSign = false;
            } else {
                if (ch >= '0' && ch <= '9') {
                    if (leadingZero) {
                        if (ch != '0') {
                            leadingZero = false;
                            result.append(ch);
                        }
                    } else
                        result.append(ch);
                } else {
                    break;
                }
            }
            index++;
        }
        if (result.isEmpty())
            return 0;
        if (result.length() > 10)
            return (int) (positive ? Math.pow(2, 31) - 1 : -Math.pow(2, 31));
        else {
            long parsed = Long.parseLong(result.toString());
            return (int) (positive ? Math.min(Math.pow(2, 31) - 1, parsed) :
                    Math.max(-Math.pow(2, 31), -parsed));
        }
    }
}
