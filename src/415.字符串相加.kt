class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.lastIndex
        var j = num2.lastIndex
        var carry = 0
        val result = StringBuilder()
        while (i >= 0 || j >= 0 || carry != 0) {
            val digital1 = if (i >= 0) num1[i--] - '0' else 0
            val digital2 = if (j >= 0) num2[j--] - '0' else 0
            val sum = digital1 + digital2 + carry
            result.append(sum % 10)
            carry = sum / 10
        }
        return result.reverse().toString()
    }
}