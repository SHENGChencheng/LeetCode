package 动态规划.分割等和子集

class CanPartition {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val target = sum / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true
        for (num in nums) {
            for (j in target downTo num) {
                dp[j] = dp[j] || dp[j - num]
            }
        }
        return dp[target]
    }
}