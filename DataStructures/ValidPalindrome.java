import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValidPalindrome {
    public boolean isPalindrome(String s){
        List<Character> array = new ArrayList<>();
        String t = s.toLowerCase();
        for (int i = 0; i < s.length(); i++){
            char ch = t.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                array.add(ch);
        }

        int forward = 0;
        int backward = array.size() - 1;

        while (forward < backward){
            if (array.get(forward)!=array.get(backward))
                return false;
            forward++;
            backward--;
        }
        return true;
    }

    public static void main(String[] argv){
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome("racecar"));
//        "race a car"
//        " ";
    }
}
