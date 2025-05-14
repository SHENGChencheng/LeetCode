package 二叉树.二叉树的中序遍历;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
