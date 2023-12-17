import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            int top = temperatures[i];
            while (!stack.empty()){
                int index = stack.peek();
                if (top > temperatures[index]){
                    stack.pop();
                    days[index] = i - index;
                }else{
                    break;
                }
            }
            stack.add(i);
        }
        return days;
    }
}
