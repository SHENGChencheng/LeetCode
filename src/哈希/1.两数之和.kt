package 哈希

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val n = nums.size
        for (i in nums.indices) {
            for (j in i + 1..<n) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
    }
}