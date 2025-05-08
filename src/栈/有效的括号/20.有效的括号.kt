package 栈.有效的括号

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val paris = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )
        val stack = mutableListOf<Char>()
        for (char in s) {
            when (char) {
                '(', '{', '[' -> stack.add(char)
                ')', '}', ']' -> if (stack.isEmpty() ||
                    stack.removeAt(stack.size - 1) != paris[char]) return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val validator = ValidParentheses()

    val testCases = listOf(
        "()[]{}" to true,
        "([)]" to false,
        "{[]}" to true,
        "(" to false,
        ")(" to false,
        "{[()()]}" to true,
        "" to true,
        "{{{{}}}}" to true
    )

    for ((input, expected) in testCases) {
        val result = validator.isValid(input)
        println("Input: \"$input\" -> Expected: $expected, Result: $result")
    }
}
