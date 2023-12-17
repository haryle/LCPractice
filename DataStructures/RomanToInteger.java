import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> record = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000
        ) ;
        Map<String, Integer> exceptions = Map.of(
                "IV", 4,
                "IX", 9,
                "XL", 40,
                "XC", 90,
                "CD", 400,
                "CM", 900
        );
        int result = 0;
        int ptr = 0;
        int size = s.length();
        char c1, c2;
        while (ptr < size){
            c1 = s.charAt(ptr);
            if (ptr+1 < size)
                c2 = s.charAt(ptr+1);
            else
                c2 = '0';
            String concat = String.format("%c%c", c1, c2);
            if (exceptions.containsKey(concat)){
                result += exceptions.get(concat);
                ptr+=2;
            }else{
                result += record.get(String.format("%c", c1));
                ptr++;
            }
        }
        return result;
    }
}
