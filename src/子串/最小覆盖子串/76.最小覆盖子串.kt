package 子串.最小覆盖子串

import kotlin.math.min

class MinWindow {
    fun minWindow(s: String, t: String): String {
        val need = mutableMapOf<Char, Int>()
        val window = mutableMapOf<Char, Int>()
        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }
        var left = 0
        var right = 0
        var valid = 0
        var start = 0
        var minLen = Int.MAX_VALUE
        while (right < s.length) {
            val ch = s[right]
            right++
            if (need.containsKey(ch)) {
                window[ch] = window.getOrDefault(ch, 0) + 1
                if (window[ch] == need[ch]) {
                    valid++
                }
            }
            while (valid == need.size) {
                if (right - left < minLen) {
                    start = left
                    minLen = right - left
                }
                val d = s[left]
                left++
                if (need.containsKey(d)) {
                    if (window[d] == need[d]) {
                        valid--
                    }
                    window[d] = window[d]!! - 1
                }
            }
        }
        return if (minLen == Int.MAX_VALUE) "" else s.substring(start, start + minLen)
    }
}