package BST;

/*
    判断BST是否正确:
        左子树最大值不能超过自己, 右子树最小值不能小于自己

    中序遍历:
        按照中序遍历访问: 当期节点一定大于上一个节点
 */

public class ValidateBST_98 {

    public boolean isValidBST(TreeNode root) {
//        return validateBST_Recursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return validateBST_InOrder(root);
    }

    long lower = Long.MIN_VALUE;

    private boolean validateBST_InOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!validateBST_InOrder(root.left)) {
            return false;
        }
        if (root.val <= lower) {
            return false;
        }
        lower = root.val;
        return validateBST_InOrder(root.right);
    }

    private boolean validateBST_Recursive(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return validateBST_Recursive(root.left, minValue, root.val) && validateBST_Recursive(root.right, root.val, maxValue);
    }


}
