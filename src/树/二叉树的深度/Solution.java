package 树.二叉树的深度;


import 树.TreeNode;

public class Solution {
    int maxDepth = 0;
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        preOrder(root, 0);
        return maxDepth;
    }
    void preOrder(TreeNode root, int depth) {
        if (root != null) {
            depth++;
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        if (root.left != null) {
            preOrder(root.left,depth);
        }
        if (root.right != null) {
            preOrder(root.right,depth);
        }
    }
}
