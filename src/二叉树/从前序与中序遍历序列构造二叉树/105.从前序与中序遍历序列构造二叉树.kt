package 二叉树.从前序与中序遍历序列构造二叉树

import common.TreeNode

class BuildTree {
    private val inorderIndexMap = mutableMapOf<Int, Int>()
    // 前序找到根，中序根据根找到左右子树，递归构建
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        for (i in inorder.indices) {
            inorderIndexMap[inorder[i]] = i
        }
        return build(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
    }

    private fun build(preorder: IntArray, preLeft: Int, preRight: Int, inorder: IntArray, inorderLeft: Int, inorderRight: Int): TreeNode? {
        if (preLeft > preRight) return null
        val rootVal = preorder[preLeft]
        val root = TreeNode(rootVal)
        val rootIndex = inorderIndexMap[rootVal]!!
        val leftSize = rootIndex - inorderLeft
        root.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inorderLeft, rootIndex - 1)
        root.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, rootIndex + 1, inorderRight)
        return root
    }
}