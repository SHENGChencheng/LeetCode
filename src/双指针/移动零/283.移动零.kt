package 双指针.移动零

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        val n = nums.size
        var left = 0
        var right = 0
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right)
                left++
            }
            right++
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val nums = intArrayOf(0,1,0,3,12)
    MoveZeroes().moveZeroes(nums)
}