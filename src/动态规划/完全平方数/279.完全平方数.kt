package 动态规划.完全平方数

class NumSquares {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1)
        for (i in 1..n) {
            var min = Int.MAX_VALUE
            var j = 1
            while (j * j <= i) {
                min = minOf(min, dp[i - j * j])
                j++
            }
            dp[i] = min + 1
        }
        return dp[n]
    }
}