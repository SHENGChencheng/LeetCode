package 双指针

class MaxArea {
    fun maxArea(height: IntArray): Int {
        val n = height.size
        var left = 0
        var right = n - 1
        var maxArea = 0
        while (left < right) {
            val area = minOf(height[left], height[right]) * (right - left)
            maxArea = maxOf(area, maxArea)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return maxArea
    }
}

fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    val maxArea = MaxArea().maxArea(height)
    println(maxArea)
}