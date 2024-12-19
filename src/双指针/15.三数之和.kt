package 双指针

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        for (first in 0..<n) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue
            }
            var third = n - 1
            val target = -nums[first]
            for (second in first + 1..<n) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third--
                }
                if (second == third) {
                    break
                }
                if (nums[second] + nums[third] == target) {
                    ans.add(listOf(nums[first], nums[second], nums[third]))
                }
            }
        }
        return ans
    }
}

fun main() {
    val nums = intArrayOf(-1,0,1,2,-1,-4)
    ThreeSum().threeSum(nums).forEach { println(it) }
}