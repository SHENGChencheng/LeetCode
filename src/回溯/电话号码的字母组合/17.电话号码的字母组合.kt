package 回溯.电话号码的字母组合

class LetterCombinations {
    fun letterCombinations(digits: String): List<String> {
        val ans = mutableListOf<String>()
        if (digits.isEmpty()) return ans
        val phoneMap = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        backtrack(ans, digits, phoneMap, "", 0)
        return ans
    }

    private fun backtrack(ans: MutableList<String>, digits: String, phoneMap: Map<Char, String>, curr: String, start: Int) {
        if (curr.length == digits.length) {
            ans.add(curr)
            return
        }
        val letters = phoneMap[digits[start]]!!
        for (ch in letters) {
            backtrack(ans, digits, phoneMap, curr + ch, start + 1)
        }
    }
}

fun main() {
    val digits = "23"
    val letterCombinations = LetterCombinations()
    val ans = letterCombinations.letterCombinations(digits)
    print(ans)
}