import java.util.Stack;

public class ValidParentheses {
    public static boolean parenMatching(char left, char right){
        return (left == '(' && right == ')') ||
               (left == '[' && right == ']') ||
               (left == '{' && right == '}');
    }

    public boolean isValid(String s) {
        Stack<Character> parenStack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                parenStack.push(ch);
            else{
                if (parenStack.isEmpty())
                    return false;
                if (!parenMatching(parenStack.pop(), ch))
                    return false;
            }
        }
        return parenStack.isEmpty();
    }

    public static void main(String[] argv){
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()")); //true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("([)")); //false
        System.out.println(solution.isValid("[)")); //false
    }
}
