package 二叉树.二叉树中的最大路径和;

import common.TreeNode;

public class MaxPathSum_124 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int currentMaxPath = leftGain + root.val + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);
        return root.val + Math.max(leftGain, rightGain);
    }
}
