package 堆

class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var heapSize = nums.size
        buildMaxHeap(nums, heapSize)
        for (i in nums.size - 1 downTo nums.size - k + 1) {
            swap(nums, 0, i)
            heapSize--
            maxHeapify(nums, 0, heapSize)
        }
        return nums[0]
    }

    private fun buildMaxHeap(nums: IntArray, heapSize: Int) {
        for (i in heapSize / 2 - 1 downTo 0) {
            maxHeapify(nums, i, heapSize)
        }
    }

    private fun maxHeapify(nums: IntArray, i: Int, heapSize: Int) {
        val left = 2 * i + 1
        val right = 2 * i + 2
        var largest = i
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right
        }
        if (largest != i) {
            swap(nums, i, largest)
            maxHeapify(nums, largest, heapSize)
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}

fun main() {
    val solution = KthLargestElement()
    println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2)) // 输出：5
}