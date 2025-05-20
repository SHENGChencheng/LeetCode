package 多维动态规划.最长回文子串

class LongestPalindrome {
    fun longestPalindrome(s: String): String {
        val n = s.length
        if (n < 2) return s
        val dp = Array(n) { BooleanArray(n) }
        var start = 0
        var maxLen = 1
        for (j in 0 until n) {
            for (i in 0..j) {
                if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1
                        start = i
                    }
                }
            }
        }
        return s.substring(start, start + maxLen)
    }
}