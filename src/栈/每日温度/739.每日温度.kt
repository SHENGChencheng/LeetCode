package 栈.每日温度

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val ans = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]) {
                val prevIndex = stack.removeLast()
                ans[prevIndex] = i - prevIndex
            }
            stack.addLast(i)
        }
        return ans
    }
}