package 树.判断是不是平衡二叉树;

import 树.TreeNode;

public class Solution {
    boolean isBalance = true;
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        // write code here
        if (pRoot == null) return true;
        postOrder(pRoot);
        return isBalance;
    }

    int postOrder(TreeNode root) {
        if (root == null) return 0;
//        if (root.left == null && root.right == null) {
//            int height = 1;
//            return height;
//        }
        int lh,rh;
        lh = postOrder(root.left);
        rh = postOrder(root.right);
        if (lh -rh > 1 || rh - lh > 1) {
            isBalance = false;
        }
        return lh > rh ? lh + 1 : rh + 1;
    }
}
