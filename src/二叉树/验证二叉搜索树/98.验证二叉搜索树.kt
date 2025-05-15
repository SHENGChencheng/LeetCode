package 二叉树.验证二叉搜索树

import common.TreeNode

class IsValidBST {
    fun isValidBST(root: TreeNode?): Boolean {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun check(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true
        if (root.`val` <= min || root.`val` >= max) return false
        return check(root.left, min, root.`val`.toLong()) &&
                check(root.right, root.`val`.toLong(), max)
    }
}