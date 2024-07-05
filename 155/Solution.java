import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minValuesStack = new ArrayDeque<>();

    public MinStack() {
        minValuesStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }

    public void pop() {
        stack.pop();
        minValuesStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValuesStack.peek();
    }
}