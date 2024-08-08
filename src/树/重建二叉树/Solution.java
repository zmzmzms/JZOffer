package 树.重建二叉树;

import 树.TreeNode;

import java.util.ArrayList;

public class Solution {
    /**
     * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
     * @param preOrder
     * @param vinOrder
     * @return
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        if (preOrder.length == 1) {
            return new TreeNode(preOrder[0]);
        }
        if (preOrder.length == 0) {
            return null;
        }
        int index = findNodeIndex(preOrder[0],vinOrder);
        TreeNode rootNode = new TreeNode(vinOrder[index]);
        int[] lVinOrder = splitArray(vinOrder,0, index - 1);
        int[] rVinOrder = splitArray(vinOrder, index+ 1, vinOrder.length -1);
        int[] lPreOrder = splitArray(preOrder, 1, lVinOrder.length);
        int[] rPreOrder = splitArray(preOrder, lVinOrder.length + 1, preOrder.length - 1);
        rootNode.left = reConstructBinaryTree(lPreOrder,lVinOrder);
        rootNode.right = reConstructBinaryTree(rPreOrder,rVinOrder);
        return rootNode;
    }


    int findNodeIndex(int n,int[] vinOrder) {
        for (int i = 0; i < vinOrder.length; i++) {
            if (vinOrder[i] == n) return i;
        }
        return -1;
    }
    int[] splitArray(int[] arr, int start,int end) {
        int[] result = new int[end - start + 1];
        for (int i = start, j = 0; i <= end; i++,j++) {
            result[j] = arr[i];
        }
        return result;
    }
}
