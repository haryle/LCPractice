import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen)
            return false;
        int[] array = new int[26];
        for (int i = 0; i < sLen; i++){
            array[s.charAt(i)-'a']+=1;
            array[t.charAt(i)-'a']-=1;
        }
        for (int val: array){
            if (val != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] argv){
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("rat", "tart"));
        System.out.println(solution.isAnagram("rat", "art"));
        System.out.println(solution.isAnagram("rat", "tars"));
    }
}
