package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_DFS_Iteration {
    static ArrayList<Integer> array = new ArrayList<>();
    static Stack<TreeNode> stack = new Stack<>();
    static Queue<TreeNode> queue = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new int[]{2, 1, 3, 5, 4, 6, 7}, 0, 7);
        System.out.println(root);
        dfs(root);
        bfs(root);
        System.out.println(array);
    }

    private static void bfs(TreeNode root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                array.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    private static void dfs(TreeNode root) {
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                array.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
    }
}
