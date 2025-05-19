package 栈.最小栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack_155 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack_155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}