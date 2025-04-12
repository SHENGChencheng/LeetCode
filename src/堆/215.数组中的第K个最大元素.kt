package 堆

class KthLargestElement {
//    fun findKthLargest(nums: IntArray, k: Int): Int {
//        var heapSize = nums.size
//        buildMaxHeap(nums, heapSize)
//        for (i in nums.size - 1 downTo nums.size - k + 1) {
//            swap(nums, 0, i)
//            heapSize--
//            maxHeapify(nums, 0, heapSize)
//        }
//        return nums[0]
//    }
//
//    private fun buildMaxHeap(nums: IntArray, heapSize: Int) {
//        for (i in heapSize / 2 - 1 downTo 0) {
//            maxHeapify(nums, i, heapSize)
//        }
//    }
//
//    private fun maxHeapify(nums: IntArray, i: Int, heapSize: Int) {
//        val left = 2 * i + 1
//        val right = 2 * i + 2
//        var largest = i
//        if (left < heapSize && nums[left] > nums[largest]) {
//            largest = left
//        }
//        if (right < heapSize && nums[right] > nums[largest]) {
//            largest = right
//        }
//        if (largest != i) {
//            swap(nums, i, largest)
//            maxHeapify(nums, largest, heapSize)
//        }
//    }
//
//    private fun swap(nums: IntArray, i: Int, j: Int) {
//        val temp = nums[i]
//        nums[i] = nums[j]
//        nums[j] = temp
//    }
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return quickSelect(nums, 0, nums.size - 1, nums.size - k)
    }

    fun quickSelect(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if (left == right) return nums[left]
        val pivotIndex = partition(nums, left, right)
        return when {
            pivotIndex == k -> nums[pivotIndex]
            pivotIndex < k -> quickSelect(nums, pivotIndex + 1, right, k)
            else -> quickSelect(nums, left, pivotIndex - 1, k)
        }
    }

    fun partition(nums: IntArray, left: Int, right: Int): Int {
        val pivot = nums[right] // 选择最右边元素为基准
        var i = left // i指向小于等于pivot的区域的末尾
        for (j in left until right) {
            if (nums[j] <= pivot) {
                nums.swap(i, j)
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

fun main() {
    val solution = KthLargestElement()
    println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 输出：5
}