package 二分查找.搜索插入位置

class SearchInsert {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }
}

fun main() {
    val solution = SearchInsert()

    // 示例测试
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 5)) // 输出: 2
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 2)) // 输出: 1

    // 边界测试
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 7)) // 输出: 4（插入末尾）
    println(solution.searchInsert(intArrayOf(1, 3, 5, 6), 0)) // 输出: 0（插入开头）

    // 空数组测试
    println(solution.searchInsert(intArrayOf(), 5))          // 输出: 0
}