import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] argv) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(5));
        System.out.println(solution.intToRoman(13));
        System.out.println(solution.intToRoman(35));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }

    public String intToRoman(int num) {
        Map<Integer, String> LUT = Map.of(
                1, "I",
                5, "V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M"
        );
        Map<Integer, String> exceptions = Map.of(
                4, "IV",
                9, "IX",
                40, "XL",
                90, "XC",
                400, "CD",
                900, "CM");
        StringBuilder builder = new StringBuilder();
        int div = 0;
        int value = num;
        int size = (int) Math.floor(Math.log10(num));
        while (size >= 0){
            int digit = (int) Math.pow(10, size);
            div = value/digit;
            value -= digit*div;
            if (div < 4){
                for (int i = 0; i < div; i++)
                    builder.append(LUT.get(digit));
            }else if (div == 4 || div == 9)
                builder.append(exceptions.get(div*digit));
            else{
                builder.append(LUT.get(digit*5));
                div -= 5;
                for (int i = 0; i < div; i++)
                    builder.append(LUT.get(digit));
            }
            size --;
        }
        return builder.toString();
    }
}
