import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {
    public static Map<Character, Integer> calculateFreq(String str){
        String lower = str.toLowerCase();
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char ch = lower.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                result.put(ch, result.getOrDefault(ch, 0)+1);
        }
        return result;
    }

    public static boolean isCompleting(Map<Character, Integer> src, Map<Character, Integer> dst){
        for (Character ch: src.keySet()){
            if (src.get(ch) > dst.getOrDefault(ch, 0))
                return false;
        }
        return true;
    }


    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> reference = calculateFreq(licensePlate);
        int length = Integer.MAX_VALUE;
        String result = "";
        for (String str: words){
            if (isCompleting(reference, calculateFreq(str))){
                if (str.length() < length){
                    length = str.length();
                    result = str;
                }
            }
        }
        return result;
    }

    public static void main(String[] argv){
        ShortestCompletingWord solution = new ShortestCompletingWord();
        System.out.println(solution.shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
        System.out.println(solution.shortestCompletingWord("1s3 456", new String[]{"looks","pest","stew","show"}));
    }

    // Best Answer
    private class Solution {
        private static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        public String shortestCompletingWord(String licensePlate, String[] words) {
            long charProduct = getCharProduct(licensePlate.toLowerCase());
            String shortest = "aaaaaaaaaaaaaaaaaaaa"; // 16 a's
            for(String word : words)
                if (word.length() < shortest.length() && getCharProduct(word) % charProduct == 0)
                    shortest = word;
            return shortest;
        }

        private long getCharProduct(String plate) {
            long product = 1L;
            for(char c : plate.toCharArray()) {
                int index = c - 'a';
                if (0 <= index && index <= 25)
                    product *= primes[index];
            }
            return product;
        }
    }
}
