import java.util.Stack;

public class MinStack {

    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;
    private int currentMin;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        currentMin = Math.min(currentMin, val);
        dataStack.push(val);
        minStack.push(currentMin);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        if (minStack.isEmpty())
            currentMin = Integer.MAX_VALUE;
        else
            currentMin = Math.max(currentMin, minStack.peek());
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] argv){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */