class SortArray {
    // 快速排序
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    fun quickSort(nums: IntArray, left: Int, right: Int) {
        if (left >= right) return
        val pivotIndex = partition(nums, left, right)
        quickSort(nums, left, pivotIndex - 1)
        quickSort(nums, pivotIndex + 1, right)
    }

    fun partition(nums: IntArray, left: Int, right: Int): Int {
        val pivot = nums[right]
        var i = left
        for (j in left until right) {
            if (nums[j] < pivot) {
                nums.swap(i , j)
                i++
            }
        }
        nums.swap(i, right)
        return i
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}