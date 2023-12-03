import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str: strs){
            char[] signature = new char[26];
            for (int i = 0; i < str.length(); i++)
                signature[str.charAt(i)-'a']++;
            String key = String.valueOf(signature);
            if (result.containsKey(key))
                result.get(key).add(str);
            else
                result.put(key, new ArrayList<>(List.of(str)));
        }
        return result.values().stream().toList();
    }

    public static void main(String[] argv){
        GroupAnagrams solution = new GroupAnagrams();
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
    }
}
