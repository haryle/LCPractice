import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    public static void main(String[] argv) {
//        String[] strs = new String[]{"abc", "d", "ef"};
        String[] strs = new String[]{""};
        EncodeAndDecodeString.Codec codec = new Codec();
        System.out.println(codec.encode(List.of(strs)));
        System.out.println(codec.decode(codec.encode(List.of(strs))));
    }

    public static class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (String str : strs) {
                if (str.isEmpty()) {
                    builder.append(-1);
                } else {
                    for (int i = 0; i < str.length(); i++) {
                        char ch = str.charAt(i);
                        builder.append(ch - 0);
                        if (i != str.length() - 1)
                            builder.append(',');
                    }
                }
                builder.append(';');
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            String[] array = s.split(";");
            List<String> retVal = new ArrayList<>();
            for (String str : array) {
                StringBuilder builder = new StringBuilder();
                String[] intVals = str.split(",");
                for (String val : intVals) {
                    int parsedInt = Integer.parseInt(val);
                    if (parsedInt == -1)
                        builder.append("");
                    else
                        builder.append(Character.toString(parsedInt));
                }
                retVal.add(builder.toString());
            }
            return retVal;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
