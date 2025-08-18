package 二叉树.路径总和3

import common.TreeNode

class PathSum {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val prefixSumCount = mutableMapOf<Long, Int>()
        prefixSumCount[0L] = 1
        return dfs(root, 0L, targetSum.toLong(), prefixSumCount)
    }

    private fun dfs(root: TreeNode?, currSum: Long, targetSum: Long, prefixSumCount: MutableMap<Long, Int>): Int {
        if (root == null) return 0
        val sum = currSum + root.`val`
        val numPathsToCurr = prefixSumCount.getOrDefault(sum - targetSum, 0)
        prefixSumCount[sum] = prefixSumCount.getOrDefault(sum, 0) + 1
        val res = numPathsToCurr +
                dfs(root.left, sum, targetSum, prefixSumCount) +
                dfs(root.right, sum, targetSum, prefixSumCount)
        prefixSumCount[sum] = prefixSumCount[sum]!! - 1
        return res
    }
}