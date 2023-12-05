package BST;

import java.util.Arrays;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(int[] array, int start, int end) {
        if (start >= end) {
            return null;
        }
        Arrays.sort(array);
        int rootIndex = (start + end) / 2;
        TreeNode root = new TreeNode(array[rootIndex]);
        root.left = build(array, start, rootIndex);
        root.right = build(array, rootIndex + 1, end);

        return root;
    }

    @Override
    public String toString() {
        return "{" +
                left +
                ", " + val +
                ", " + right +
                '}';
    }
}
