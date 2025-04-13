package 贪心算法

class CanJump {
    fun canJump(nums: IntArray): Boolean {
        var maxPos = 0
        for (i in nums.indices) {
            if (i <= maxPos) {
                maxPos = maxOf(maxPos, i + nums[i])
            }
            if (maxPos >= nums.size - 1) {
                return true
            }
        }
        return false
    }
}