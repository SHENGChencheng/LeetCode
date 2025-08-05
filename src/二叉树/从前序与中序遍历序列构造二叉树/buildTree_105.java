package 二叉树.从前序与中序遍历序列构造二叉树;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree_105 {
    private Map<Integer, Integer> inOrderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        // 前序的第一个是根
        int rootVal = preorder[preLeft];
        // 找到根在中序的位置
        int rootIndex = inOrderIndexMap.get(rootVal);
        int leftSize = rootIndex - inLeft;
        TreeNode root = new TreeNode(rootVal);
        // 递归构建左子树
        root.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, rootIndex - 1);
        // 递归构建右子树
        root.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }
}
