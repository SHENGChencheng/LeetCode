package 二叉树

import common.TreeNode

class MaxDepth {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}

fun main() {
    val maxDepth = MaxDepth()
    // 示例测试
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.left!!.left = TreeNode(15)
    root.left!!.right = TreeNode(7)
    println(maxDepth.maxDepth(root)) // 输出: 3
}