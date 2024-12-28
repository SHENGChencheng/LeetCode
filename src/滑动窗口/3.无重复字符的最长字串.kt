package 滑动窗口

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val n = s.length
        val set = mutableSetOf<Char>()
        var left = 0
        var right = 0
        var ans = 0
        while (right < n) {
            while (set.contains(s[right])) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            ans = maxOf(ans, right - left + 1)
            right++
        }
        return ans
    }
}

fun main() {
    val s = "abcabcbb"
    println(LengthOfLongestSubstring().lengthOfLongestSubstring(s))
}