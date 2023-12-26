package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    backTrack_1: 使用list添加
    backTrack_2: 使用swap交换
 */

public class Permutations_46 {
    public static void main(String[] args) {
        Permutations_46 solution = new Permutations_46();
        int[] nums = {1, 2, 3};
        System.out.println(solution.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        for (int num : nums) {
            path.add(num);
        }
        boolean[] used = new boolean[nums.length];
        backTrack_1(0, nums, used, new ArrayList<Integer>(), res);
//        backTrack_2(0, nums, path, res);
        return res;
    }

    private void backTrack_1(int turn, int[] nums, boolean[] used, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (turn == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrack_1(turn + 1, nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    private void backTrack_2(int turn, int[] nums, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (turn == nums.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = turn; i < nums.length; i++) {
            Collections.swap(path, turn, i);
            backTrack_2(turn + 1, nums, path, res);
            Collections.swap(path, i, turn);
        }
    }
}
