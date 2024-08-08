package 树.二叉搜索树的第k个节点;

import 树.TreeNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public int KthNode (TreeNode proot, int k) {
        if (proot == null) return -1;
        inorder(proot);
        if (k <= 0 || k>arrayList.size()) return -1;
        return arrayList.get(k -1);
    }
    void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        arrayList.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }
}
