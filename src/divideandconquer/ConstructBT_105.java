package divideandconquer;

import java.util.HashMap;

/*
    构造树重点是找到root节点, 然后将树分为左子树和右子树递归构造
    二叉树三序遍历:
        前序 preorder: root - left - right
        中序 inorder: left - root - right
        后序 postorder: left - right - root
 */

public class ConstructBT_105 {
    static HashMap<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int length = preorder.length - 1;
        return treeBuilder(preorder, 0, length, inorder, 0, length);
    }

    public static TreeNode treeBuilder(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = indexMap.get(root.val);
        int leftTreeNum = rootIndex - inStart;

        root.left = treeBuilder(preorder, preStart + 1, preStart + leftTreeNum, inorder, inStart, rootIndex - 1);
        root.right = treeBuilder(preorder, preStart + leftTreeNum + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
