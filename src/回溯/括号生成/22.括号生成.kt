package 回溯.括号生成

class generateParenthesis {
    fun generateParenthesis(n: Int): List<String> {
        val ans = mutableListOf<String>()
        backtrack(ans, "", 0, 0, n)
        return ans
    }

    private fun backtrack(ans: MutableList<String>, cur: String, open: Int, close: Int, max: Int) {
        if (cur.length == max * 2) {
            ans.add(cur)
            return
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max)
        }
        if (close < open) {
            backtrack(ans, cur + ")", open, close + 1, max)
        }
    }
}

fun main() {
    val n = 3
    val generateParenthesis = generateParenthesis()
    val ans = generateParenthesis.generateParenthesis(n)
    print(ans)
}