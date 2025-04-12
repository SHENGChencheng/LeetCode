package 多维动态规划

class LongestCommonSubsequence {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in text1.indices) {
            for (j in text2.indices) {
                dp[i + 1][j + 1] = if (text1[i] == text2[j]) {
                    dp[i][j] + 1
                } else {
                    maxOf(dp[i][j + 1], dp[i + 1][j])
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