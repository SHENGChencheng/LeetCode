package 二叉树.子结构判断

import common.TreeNode

class IsSubStructure_143 {
    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null || B == null) {
            return false
        }
        return isSameStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
    }

    private fun isSameStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if (B == null) {
            return true
        }
        if (A == null || A.`val` != B.`val`) {
            return false
        }
        return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right)
    }
}
