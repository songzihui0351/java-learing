package BST;

import java.util.*;

public class BSTZigzag_103 {
    public static void main(String[] args) {
        BSTZigzag_103 solution = new BSTZigzag_103();
        List<List<Integer>> list = solution.zigzagLevelOrder(new TreeNode());
    }

    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root, 0);
        return res;
    }

    public void bfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= res.size()) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(level, list);
        } else {
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
        }
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}
