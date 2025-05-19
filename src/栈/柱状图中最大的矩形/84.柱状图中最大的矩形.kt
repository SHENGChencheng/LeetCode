package 栈.柱状图中最大的矩形

class LargestRectangleArea {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size
        val stack = ArrayDeque<Int>()
        var maxArea = 0
        for (i in 0..n) {
            val currentHeight = if (i == n) 0 else heights[i]
            while (stack.isNotEmpty() && currentHeight < heights[stack.last()]) {
                val top = stack.removeLast()
                val height = heights[top]
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.addLast(i)
        }
        return maxArea
    }
}