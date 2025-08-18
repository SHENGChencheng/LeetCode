package 二叉树.路径总和2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum_113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, res, path);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum - root.val, res, path);
        dfs(root.right, targetSum - root.val, res, path);
        path.removeLast();
    }
}
