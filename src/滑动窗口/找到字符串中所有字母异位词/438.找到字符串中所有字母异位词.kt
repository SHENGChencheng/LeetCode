package 滑动窗口.找到字符串中所有字母异位词

class FindAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans = mutableListOf<Int>()
        if (s.length < p.length) return ans
        val pCount = IntArray(26)
        val sCount = IntArray(26)
        for (i in p.indices) {
            pCount[p[i] - 'a']++
            sCount[s[i] - 'a']++
        }
        if (pCount.contentEquals(sCount)) {
            ans.add(0)
        }
        for (i in p.length until s.length) {
            sCount[s[i - p.length] - 'a']--
            sCount[s[i] - 'a']++
            if (pCount.contentEquals(sCount)) {
                ans.add(i - p.length + 1)
            }
        }
        return ans
    }
}

fun main() {
    val solution = FindAnagrams()

    // 示例测试
    println(solution.findAnagrams("cbaebabacd", "abc")) // 输出: [0, 6]

    // 边界测试
    println(solution.findAnagrams("abab", "ab"))       // 输出: [0, 1, 2]
    println(solution.findAnagrams("aaaaa", "aa"))      // 输出: [0, 1, 2, 3]

    // 无匹配测试
    println(solution.findAnagrams("abcdefg", "xyz"))   // 输出: []
}