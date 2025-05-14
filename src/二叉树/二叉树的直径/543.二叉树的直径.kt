package 二叉树.二叉树的直径

import common.TreeNode

class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return leftDepth + rightDepth
    }

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}