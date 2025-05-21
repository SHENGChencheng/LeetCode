package 技巧.多数元素

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        // 摩尔投票法，遇到相同的数就投一票，遇到不同的数就减一票，最后还存在票的数就是众数
        var count = 0
        var candidate = nums[0]
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }
        return candidate
    }
}