public class ReverseInteger {
    public int reverse(int x) {
        boolean positive = x >= 0;
        String digits = String.valueOf(Math.abs((long) x));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < digits.length(); i++){
            builder.append(digits.charAt(digits.length() - 1 - i));
        }
        long result = Long.parseLong(builder.toString());
        result = positive?result:-result;
        return (int) (positive?(Integer.MAX_VALUE<result?0:result):(Integer.MIN_VALUE> result?0:result));
    }

    public static void main(String[] argv){
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(-2147483648));
    }
}
