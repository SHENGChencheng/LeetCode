package 普通数组

class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var currentMax = nums[0]
        var ans = nums[0]
        for (i in 1 until nums.size) {
            currentMax = maxOf(currentMax + nums[i], nums[i])
            ans = maxOf(ans, currentMax)
        }
        return ans
    }
}

fun main() {
    val solution = MaxSubArray()

    // 测试用例1: 普通正负数混合数组
    val nums1 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println("测试1: ${nums1.contentToString()}")
    println("结果: ${solution.maxSubArray(nums1)}") // 应输出6（子数组[4,-1,2,1]）

    // 测试用例2: 全正数数组
    val nums2 = intArrayOf(1, 2, 3, 4)
    println("\n测试2: ${nums2.contentToString()}")
    println("结果: ${solution.maxSubArray(nums2)}") // 应输出10（整个数组）

    // 测试用例3: 全负数数组
    val nums3 = intArrayOf(-5, -3, -2, -8)
    println("\n测试3: ${nums3.contentToString()}")
    println("结果: ${solution.maxSubArray(nums3)}") // 应输出-2（单个元素-2）

    // 测试用例4: 单个元素数组
    val nums4 = intArrayOf(7)
    println("\n测试4: ${nums4.contentToString()}")
    println("结果: ${solution.maxSubArray(nums4)}") // 应输出7

    // 测试用例5: 空数组（根据题目要求可能返回0或报错）
    val nums5 = intArrayOf()
    println("\n测试5: ${nums5.contentToString()}")
    println("结果: ${solution.maxSubArray(nums5)}") // 应输出0（当前实现返回0）

    // 测试用例6: 最大和在数组末尾
    val nums6 = intArrayOf(1, -2, 3, -1, 5)
    println("\n测试6: ${nums6.contentToString()}")
    println("结果: ${solution.maxSubArray(nums6)}") // 应输出7（子数组[3,-1,5]）

    // 测试用例7: 最大和在数组开头
    val nums7 = intArrayOf(5, -4, 3, -2, 1)
    println("\n测试7: ${nums7.contentToString()}")
    println("结果: ${solution.maxSubArray(nums7)}") // 应输出5（子数组[5]）

    // 测试用例8: 交替正负数
    val nums8 = intArrayOf(1, -1, 1, -1, 1)
    println("\n测试8: ${nums8.contentToString()}")
    println("结果: ${solution.maxSubArray(nums8)}") // 应输出1（任意单个1）
}