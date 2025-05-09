package 滑动窗口.无重复字符的最长子串

class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var left = 0
        var ans = 0
        for (right in s.indices) {
            while (set.contains(s[right])) {
                set.remove(s[left++])
            }
            set.add(s[right])
            ans = maxOf(ans, right - left + 1)
        }
        return ans
    }
}

fun main() {
    val s = "abcabcbb"
    println(LengthOfLongestSubstring().lengthOfLongestSubstring(s))
}