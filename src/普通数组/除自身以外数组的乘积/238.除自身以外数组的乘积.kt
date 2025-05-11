package 普通数组.除自身以外数组的乘积

class ProductionExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val ans = IntArray(n)
        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = 1
        right[n - 1] = 1
        for (i in 1 until n) {
            left[i] = left[i - 1] * nums[i - 1]
        }
        for (i in n - 2 downTo 0) {
            right[i] = right[i + 1] * nums[i + 1]
        }
        for (i in 0 until n) {
            ans[i] = left[i] * right[i]
        }
        return ans
    }
}