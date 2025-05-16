package 二分查找.在排序数组中查找元素的第一个和最后一个位置

class SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = findFirst(nums, target)
        val last = findLast(nums, target)
        return intArrayOf(first, last)
    }

    private fun findFirst(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
                else -> ans = mid.also { right = mid - 1 }
            }
        }
        return ans
    }

    private fun findLast(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
                else -> ans = mid.also { left = mid + 1 }
            }
        }
        return ans
    }
}