package 栈.字符串解码

class DecodeString {
    fun decodeString(s: String): String {
        val numStack = ArrayDeque<Int>() // 保存重复次数
        val strStack = ArrayDeque<String>() // 保存之前构造好的字符串
        var currentStr = StringBuilder() // 当前正在构建的字符串
        var num = 0
        for (ch in s) {
            when {
                ch.isDigit() -> {
                    num = num * 10 + (ch - '0')
                }
                ch == '[' -> {
                    // 保存当前的字符串和重复次数，准备进入新的一层
                    numStack.addLast(num)
                    num = 0
                    strStack.addLast(currentStr.toString())
                    currentStr = StringBuilder()
                }
                ch == ']' -> {
                    // 取出栈顶元素，拼接重复后的字符串，并合之前的结果合并
                    val repeatTimes = numStack.removeLast()
                    val prevStr = strStack.removeLast()
                    val newStr = StringBuilder(prevStr)
                    repeat(repeatTimes) {
                        newStr.append(currentStr)
                    }
                    currentStr = newStr
                }
                else -> {
                    currentStr.append(ch)
                }
            }
        }
        return currentStr.toString()
    }
}