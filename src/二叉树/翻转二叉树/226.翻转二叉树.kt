package 二叉树.翻转二叉树

import common.TreeNode

class InvertTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val left = invertTree(root.left)
        val right = invertTree(root.right)
        root.left = left
        root.right = right
        return root
    }
}