package 二叉树.对称二叉树

import com.sun.source.tree.Tree
import common.TreeNode

class IsSymmetric {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return isMirror(root.left, root.right)
    }

    fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        return left.`val` == right.`val`
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left)
    }
}