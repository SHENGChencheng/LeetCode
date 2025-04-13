package 二叉树

import common.TreeNode

class InorderTraversal {
    fun InorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        inorder(root, ans)
        return ans
    }

    fun inorder(root: TreeNode?, ans: MutableList<Int>) {
        if (root == null) return
        inorder(root.left, ans)
        ans.add(root.`val`)
        inorder(root.right, ans)
    }
}

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    val inorderTraversal = InorderTraversal()
    val ans = inorderTraversal.InorderTraversal(root)
    print(ans)
}