package 二叉树.将有序数组转换为二叉搜索树

import common.TreeNode

class SortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return build(nums, 0, nums.size - 1)
    }

    private fun build(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = (left + right) / 2
        val root = TreeNode(nums[mid])
        root.left = build(nums, left, mid - 1)
        root.right = build(nums, mid + 1, right)
        return root
    }
}