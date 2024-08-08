package 树.二叉树的镜像;

import 树.TreeNode;

public class Solution {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        preOrder(pRoot);
        return pRoot;
    }
    void preOrder(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }else {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
    }
}
