package 二叉树.二叉搜索树中第K小的元素;

import common.TreeNode;

public class KthSmallest_230 {
    private int count = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
