package 普通数组.轮转数组

class Rotate {
    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val newNums = IntArray(n)
        for (i in nums.indices) {
            newNums[(i + k) % n] = nums[i]
        }
        System.arraycopy(newNums, 0, nums, 0, n)
    }
}