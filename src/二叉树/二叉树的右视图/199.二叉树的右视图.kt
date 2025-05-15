package 二叉树.二叉树的右视图

import common.TreeNode

class rightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) return ans
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.removeFirst()
                if (i == size - 1) {
                    ans.add(node.`val`)
                }
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
            }
        }
        return ans
    }
}