package 二叉树.二叉搜索树中第K小的元素

import common.TreeNode

class KthSmallest {
    private var count = 0
    private var result = 0
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root, k)
        return result
    }

    private fun inorder(root: TreeNode?, k: Int) {
        if (root == null) return
        inorder(root.left, k)
        count++
        if (count == k) {
            result = root.`val`
            return
        }
        inorder(root.right, k)
    }
}