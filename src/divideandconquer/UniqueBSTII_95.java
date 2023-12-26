package divideandconquer;

import java.util.ArrayList;
import java.util.List;

/*
    递归法, 注意返回null! 否则会少很多树
 */
public class UniqueBSTII_95 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateTrees(n));
    }

    public static List<TreeNode> generateTrees(int n) {
        return subTrees(1, n);
    }

    private static List<TreeNode> subTrees(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = subTrees(start, i - 1);
            List<TreeNode> right = subTrees(i + 1, end);
            for (TreeNode leftTree : left) {
                for (TreeNode rightTree : right) {
                    res.add(new TreeNode(i, leftTree, rightTree));
                }
            }
        }
        return res;
    }

}


