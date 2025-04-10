package 多维动态规划

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1)}

        for (i in 1..m) {
            val c1 = text1[i - 1]
            for (j in 1..n) {
                val c2 = text2[j - 1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[m][n]
    }
}

fun main() {
    val longestCommonSubsequence = LongestCommonSubsequence()
    println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"))   // 应输出 3
    println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"))     // 应输出 0
    println(longestCommonSubsequence.longestCommonSubsequence("aab", "aba"))     // 应输出 2
}