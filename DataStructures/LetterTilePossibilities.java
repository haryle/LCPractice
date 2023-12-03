import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {

    public static void permutate(Set<String> sequence, char ch){
        Set<String> toAdd = new HashSet<>();
        toAdd.add(String.valueOf(ch));
        for (String str: sequence){
            for (int i = 0; i < str.length(); i++){
                StringBuilder builder = new StringBuilder();
                builder.append(str.substring(0, i));
                builder.append(ch);
                builder.append(str, i, str.length());
                toAdd.add(builder.toString());
            }
            StringBuilder builder = new StringBuilder(str);
            builder.append(ch);
            toAdd.add(builder.toString());
        }
        sequence.addAll(toAdd);
    }

    public int numTilePossibilities(String tiles) {
        Set<String> sequence = new HashSet<>();
        for (int i = 0; i < tiles.length(); i++){
            permutate(sequence, tiles.charAt(i));
        }
        return sequence.size();
    }

    public static void main(String[] argv){
        LetterTilePossibilities solution = new LetterTilePossibilities();
        System.out.println(solution.numTilePossibilities("V"));
    }
}
