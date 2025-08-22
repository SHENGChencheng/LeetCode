package 未分类.自定义栈和队列;

public class MyStack<T> {
    private Object[] elements; // 用 Object 数组存储元素（泛型擦除后用 Object）
    private int top;           // 栈顶指针，指向下一个可插入位置
    private int capacity;      // 栈容量

    public MyStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        top = 0;
    }

    // 压栈
    public void push(T item) {
        if (top == capacity) {
            throw new RuntimeException("栈满，不能再放入元素");
        }
        elements[top++] = item;
    }

    // 出栈
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，不能出栈");
        }
        T item = (T) elements[--top];
        elements[top] = null; // 避免内存泄漏
        return item;
    }

    // 查看栈顶
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有栈顶元素");
        }
        return (T) elements[top - 1];
    }

    // 判断是否为空
    public boolean isEmpty() {
        return top == 0;
    }

    // 返回元素数量
    public int size() {
        return top;
    }

    // 测试
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("栈顶元素: " + stack.peek()); // 30
        System.out.println("出栈: " + stack.pop());      // 30
        System.out.println("栈顶元素: " + stack.peek()); // 20
        System.out.println("当前大小: " + stack.size()); // 2
        System.out.println("是否为空: " + stack.isEmpty()); // false
    }
}

