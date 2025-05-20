package 动态规划.乘积最大子数组

import kotlin.math.max

class MaxProduct {
    fun maxProduct(nums: IntArray): Int {
        var maxProd = nums[0]
        var minProd = nums[0]
        var ans = nums[0]
        for (i in 1 until nums.size) {
            val curr = nums[i]
            val tempMax = maxOf(curr, maxProd * curr, minProd * curr)
            val tempMin = minOf(curr, maxProd * curr, minProd * curr)
            maxProd = tempMax
            minProd = tempMin
            ans = maxOf(ans, maxProd)
        }
        return ans
    }
}