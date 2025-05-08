package 多维动态规划.不同路径

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            dp[i][0] = 1
        }
        for (j in 0 until n) {
            dp[0][j] = 1
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}

fun main() {
    val uniquePaths = UniquePaths()
    println(uniquePaths.uniquePaths(3, 7))   // 输出: 28
    println(uniquePaths.uniquePaths(3, 2))   // 输出: 3
}