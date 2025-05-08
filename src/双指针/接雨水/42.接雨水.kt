package 双指针.接雨水

class Trap {
    fun trap(height: IntArray): Int {
        val size = height.size
        if (size == 0) return 0
        val leftMax = IntArray(size)
        leftMax[0] = height[0]
        for (i in 1 until size) {
            leftMax[i] = maxOf(leftMax[i - 1], height[i])
        }
        val rightMax = IntArray(size)
        rightMax[size - 1] = height[size - 1]
        for (i in size - 2 downTo 0) {
            rightMax[i] = maxOf(rightMax[i + 1], height[i])
        }
        var ans = 0
        for (i in 0 until size) {
            ans += minOf(leftMax[i], rightMax[i]) - height[i]
        }
        return ans
    }
}