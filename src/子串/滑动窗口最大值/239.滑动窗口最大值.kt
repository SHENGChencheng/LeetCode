package 子串.滑动窗口最大值

class MaxSlidingWindow {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val deque = ArrayDeque<Int>();
        for (i in 0 until k) {
            while (deque.isNotEmpty() && nums[i] >= nums[deque.last()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        val ans = IntArray(nums.size - k + 1);
        ans[0] = nums[deque.first()]
        for (i in k until nums.size) {
            while (deque.isNotEmpty() && nums[i] >= nums[deque.last()]) {
                deque.removeLast()
            }
            deque.addLast(i);
            while (deque.first() <= i - k) {
                deque.removeFirst()
            }
            ans[i - k + 1] = nums[deque.first()]
        }
        return ans
    }
}

fun main() {
    val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
    val k = 3
    println(MaxSlidingWindow().maxSlidingWindow(nums, k).contentToString())
}