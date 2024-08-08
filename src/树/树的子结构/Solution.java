package 树.树的子结构;

import 树.TreeNode;

public class Solution {
    boolean result = true;
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        preOrder(root1, root2);
        return result;
    }
    void preOrder(TreeNode root1, TreeNode root2) {
        if (result == false) return;
        if ((root1 != null && root2 == null) || (root2 != null && root1 == null)) {
            result = false;
            return;
        }
        preOrder(root1.left, root2.left);
        preOrder(root1.right, root2.right);
    }
}
