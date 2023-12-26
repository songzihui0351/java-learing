package bst;

import java.util.ArrayList;
import java.util.List;

/*
    BFS递归需要借助 层级+DFS 来实现
 */

public class BFS_DFS_Recursive {
    public static ArrayList<Integer> DFSList = new ArrayList<>();
    public static List<List<Integer>> BFSList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new int[]{2, 1, 3, 5, 4, 6, 7}, 0, 7);
        System.out.println(root);
        dfs(root);
        System.out.println(DFSList);
        bfs(root, 0);
        System.out.println(BFSList);
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        DFSList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    private static void bfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= BFSList.size()) {
            ArrayList<Integer> nextLevel = new ArrayList<>();
            nextLevel.add(root.val);
            BFSList.add(nextLevel);
        } else {
            BFSList.get(level).add(root.val);
        }
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}
