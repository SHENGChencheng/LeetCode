package 技巧.下一个排列

class NextPermutation {
    fun nextPermutation(nums: IntArray) {
        var i = nums.size - 2
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--
        }
        if (i >= 0) {
            var j = nums.size - 1
            while (nums[j] < nums[i]) {
                j--
            }
            nums.swap(i, j)
        }
        nums.reverse(i + 1, nums.size - 1)
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun IntArray.reverse(i: Int, j: Int) {
        var start = i
        var end = j
        while (start < end) {
            swap(start++, end--)
        }
    }
}