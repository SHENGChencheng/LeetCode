package 二叉树.翻转二叉树;

import com.sun.source.tree.Tree;
import common.TreeNode;

public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
