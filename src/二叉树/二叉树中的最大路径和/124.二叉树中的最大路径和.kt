package 二叉树.二叉树中的最大路径和

import common.TreeNode

class MaxPathSum {
    var maxSum = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        maxGain(root)
        return maxSum
    }

    private fun maxGain(root: TreeNode?): Int {
        if (root == null) return 0
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        val leftGain = maxOf(maxGain(root.left), 0)
        val rightGain = maxOf(maxGain(root.right), root.`val`)
        // 当前节点的最大路径和 = 左 + 当前 + 右
        val currentMaxPath = root.`val` + leftGain + rightGain
        maxSum = maxOf(maxSum, currentMaxPath)
        // 向上传递的最大贡献值（只能选一边）
        return root.`val` + maxOf(leftGain, rightGain)
    }
}