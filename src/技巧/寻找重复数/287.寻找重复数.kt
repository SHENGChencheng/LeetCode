package 技巧.寻找重复数

class FindDuplicate {
    fun findDuplicates(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]
        // 找相遇点
        do {
            slow = nums[slow] // 每次走一步
            fast = nums[nums[fast]] // 每次走两步
        } while (slow != fast)
        slow = nums[0]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }
}