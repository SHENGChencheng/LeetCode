package 回溯.分割回文串

class Partition {
    fun partition(s: String): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val path = mutableListOf<String>()
        backtrack(s, ans, path, 0)
        return ans
    }

    private fun backtrack(s: String, ans: MutableList<List<String>>, path: MutableList<String>, start: Int) {
        if (start == s.length) {
            ans.add(ArrayList(path))
            return
        }
        for (end in (start + 1)..s.length) {
            val substring = s.substring(start, end)
            if (isPalindrome(substring)) {
                path.add(substring)
                backtrack(s, ans, path, end)
                path.removeAt(path.size - 1)
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left++] != s[right--]) return false
        }
        return true
    }
}

fun main() {
    val input = "aab"
    val result = Partition().partition(input)
    println(result)
}