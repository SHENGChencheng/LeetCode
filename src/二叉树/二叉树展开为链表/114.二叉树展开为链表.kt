package 二叉树.二叉树展开为链表

import common.TreeNode

class Flatten {
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val stack = ArrayDeque<TreeNode>()
        stack.add(root)
        var pre: TreeNode? = null
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()
            pre?.left = null
            pre?.right = cur
            cur.right?.let { stack.add(it) }
            cur.left?.let { stack.add(it) }
            pre = cur
        }
    }
}