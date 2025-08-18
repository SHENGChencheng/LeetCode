package 二叉树.路径总和2

import common.TreeNode

class PathSum {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        dfs(root, targetSum, res, path)
        return res
    }

    private fun dfs(root: TreeNode?, targetSum: Int, res: MutableList<List<Int>>, path: MutableList<Int>) {
        if (root == null) return
        path.add(root.`val`)
        if (root.left == null && root.right == null && targetSum == root.`val`) {
            res.add(path.toList())
        }
        dfs(root.left, targetSum - root.`val`, res, path)
        dfs(root.right, targetSum - root.`val`, res, path)
        path.removeLast()
    }
}