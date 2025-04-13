package 二叉树

import common.TreeNode

class LevelOrder {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            ans.add(level)
        }
        return ans
    }
}

fun main() {
    val levelOrder = LevelOrder()
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.left!!.left = TreeNode(15)
    root.left!!.right = TreeNode(7)
    println(levelOrder.levelOrder(root))
}