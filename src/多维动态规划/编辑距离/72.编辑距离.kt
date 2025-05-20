package 多维动态规划.编辑距离

class minDistance {
    fun minDistance(word1: String, word2: String): Int {
        // dp[i][j] 表示 word1 的前 i 个字符转换成 word2 的前 j 个字符的最小操作数
        val m = word1.length
        val n = word2.length
        val dp = Array(m + 1) { IntArray(n + 1)}
        for (i in 0..m) dp[i][0] = i
        for (j in 0..n) dp[0][j] = j
        for (i in 1..m) {
            for (j in 1..n) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = minOf(
                        dp[i - 1][j - 1] + 1, // 替换
                        dp[i][j - 1] + 1, // 插入
                        dp[i - 1][j] + 1 // 删除
                    )
                }
            }
        }
        return dp[m][n]
    }
}