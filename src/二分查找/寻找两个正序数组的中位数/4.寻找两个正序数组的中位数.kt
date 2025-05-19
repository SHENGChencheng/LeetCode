package 二分查找.寻找两个正序数组的中位数

class FindMedianSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalLen = nums1.size + nums2.size
        if (totalLen % 2 == 1) {
            return getKthElement(nums1, nums2, totalLen / 2 + 1).toDouble()
        } else {
            val left = getKthElement(nums1, nums2, totalLen / 2)
            val right = getKthElement(nums1, nums2, totalLen / 2 + 1)
            return (left + right) / 2.0
        }
    }

    private fun getKthElement(nums1: IntArray, nums2: IntArray, k: Int): Int {
        var index1 = 0
        var index2 = 0
        val len1 = nums1.size
        val len2 = nums2.size
        var kth = k
        while (true) {
            if (index1 == len1) return nums2[index2 + kth - 1]
            if (index2 == len2) return nums1[index1 + kth - 1]
            if (kth == 1) return minOf(nums1[index1], nums2[index2])

            val half = kth / 2
            val newIndex1 = minOf(index1 + half, len1) - 1
            val newIndex2 = minOf(index2 + half, len2) - 1
            val pivot1 = nums1[newIndex1]
            val pivot2 = nums2[newIndex2]
            if (pivot1 <= pivot2) {
                kth -= newIndex1 - index1 + 1
                index1 = newIndex1 + 1
            } else {
                kth -= newIndex2 - index2 + 1
                index2 = newIndex2 + 1
            }
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1, 3)
    val nums2 = intArrayOf(2)
    val solution = FindMedianSortedArrays()
    println(solution.findMedianSortedArrays(nums1, nums2))
}