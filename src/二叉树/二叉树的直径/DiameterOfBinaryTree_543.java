package 二叉树.二叉树的直径;

import common.TreeNode;

public class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left + right;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
