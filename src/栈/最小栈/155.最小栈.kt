package 栈.最小栈

class MinStack {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(x: Int) {
        stack.addLast(x)
        if (minStack.isEmpty() || x < minStack.last()) {
            minStack.addLast(x)
        } else {
            minStack.addLast(minStack.last())
        }
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}