package divideandconquer;

import java.util.HashMap;

/*
    构造树重点是找到root节点, 然后将树分为左子树和右子树递归构造
    二叉树三序遍历:
        前序 preorder: root - left - right
        中序 inorder: left - root - right
        后序 postorder: left - right - root

    注意边界问题!
 */

public class ConstructBT_106 {
    static HashMap<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(buildTree(inorder, postorder));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int length = inorder.length - 1;
        return TreeBuilder(inorder, 0, length, postorder, 0, length);
    }

    private static TreeNode TreeBuilder(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        int rootIndex = indexMap.get(root.val);
        int leftTreeNum = rootIndex - inLeft;
        int rightTreeNum = inRight - rootIndex;

        root.left = TreeBuilder(inorder, inLeft, rootIndex - 1, postorder, postLeft, postLeft + leftTreeNum - 1);
        root.right = TreeBuilder(inorder, rootIndex + 1, inRight, postorder, postRight - rightTreeNum, postRight - 1);

        return root;
    }
}
