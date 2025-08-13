package 双指针.删除有序数组中的重复项

class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): IntArray {
        if (nums.size <= 2) return nums
        var slow = 2
        for (fast in 2 until nums.size) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast]
                slow++
            }
        }
        return nums.copyOfRange(0, slow)
    }
}