package 二叉树.子结构判断;

import common.TreeNode;

public class isSubStructure_143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSameStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSameStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSameStructure(A.left, B.left) && isSameStructure(A.right, B.right);
    }
}
