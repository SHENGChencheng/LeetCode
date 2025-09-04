package 二叉树.二叉树的锯齿形层序遍历

import common.TreeNode
import java.util.LinkedList

class ZigzagLevelOrder {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var isOrderLeft = true
        while (queue.isNotEmpty()) {
            val level = LinkedList<Int>()
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.removeFirst()
                if (isOrderLeft) {
                    level.addLast(node.`val`)
                } else {
                    level.addFirst(node.`val`)
                }
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
            ans.add(level)
            isOrderLeft = !isOrderLeft
        }
        return ans
    }
}
