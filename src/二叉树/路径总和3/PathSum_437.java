package 二叉树.路径总和3;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum_437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode root, long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (root == null) return 0;
        Long sum = currSum + root.val;
        int count = prefixSumCount.getOrDefault(sum - targetSum, 0);
        prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        int res = count +
                dfs(root.left, sum, targetSum, prefixSumCount) +
                dfs(root.right, sum, targetSum, prefixSumCount);
        prefixSumCount.put(sum, prefixSumCount.get(sum) - 1);
        return res;
    }
}
