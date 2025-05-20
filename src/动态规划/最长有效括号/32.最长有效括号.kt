package 动态规划.最长有效括号

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {
        val stack = ArrayDeque<Int>()
        stack.add(-1)
        var maxLen = 0
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.addLast(i)
            } else {
                stack.removeLast()
                if (stack.isEmpty()) {
                    stack.addLast(i)
                } else {
                    maxLen = maxOf(maxLen, i - stack.last());
                }
            }
        }
        return maxLen
    }
}

fun main() {
    val s = "(()"
    val longestValidParentheses = LongestValidParentheses()
    println(longestValidParentheses.longestValidParentheses(s))
}