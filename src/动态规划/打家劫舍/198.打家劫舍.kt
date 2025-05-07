package 动态规划.打家劫舍

class Rob() {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 2] + nums[i], dp[i - 1])
        }
        return dp[nums.size - 1]
    }
}

fun main() {
    val rob = Rob()
    val nums = intArrayOf(1, 2, 3, 1)
    println(rob.rob(nums))
}