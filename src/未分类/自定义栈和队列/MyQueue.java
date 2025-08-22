package 未分类.自定义栈和队列;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // 入队
    public void push(int x) {
        stackIn.push(x);
    }

    // 出队
    public int pop() {
        if (stackOut.isEmpty()) {
            // 将 stackIn 全部倒到 stackOut
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    // 查看队头元素
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    // 判断是否为空
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
