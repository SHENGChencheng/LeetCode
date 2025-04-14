package 动态规划

class LengthOfLIS {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val dp = IntArray(nums.size) { 1 }
        var ans = 1
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
            ans = maxOf(ans, dp[i])
        }
        return ans
    }
}