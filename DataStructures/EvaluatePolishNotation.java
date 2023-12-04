import java.util.List;
import java.util.Stack;

public class EvaluatePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operandStack = new Stack<>();
        List<String> operands = List.of("+", "-", "*", "/");
        for (String str : tokens) {
            if (operands.contains(str)) {
                int second = operandStack.pop();
                int first = operandStack.pop();
                int result;
                if (str.equals("+"))
                    result = first + second;
                else if (str.equals("-"))
                    result = first - second;
                else if (str.equals("*"))
                    result = first * second;
                else
                    result = first / second;
                operandStack.push(result);
            } else
                operandStack.push(Integer.parseInt(str));
        }
        return operandStack.pop();
    }

    public static void main(String[] argv) {
        EvaluatePolishNotation solution = new EvaluatePolishNotation();
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens));
        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens));
    }
}
