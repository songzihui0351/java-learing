package bst;

/*
   中序遍历递归:
        dfs(root.left);
        对当前node操作
        dfs(root.right);
 */

public class RecoveryBST_99 {
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (first != null && second != null) {
            swap(first, second);
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (pre != null) {
            if (pre.val >= root.val) {
                first = root;
                if (second == null) {
                    second = pre;
                }
            }
        }
        pre = root;

        dfs(root.right);
    }

    private void swap(TreeNode first, TreeNode second) {
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
