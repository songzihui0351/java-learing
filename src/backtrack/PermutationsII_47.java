package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
    回溯: 去重可以引入新的数组或者hash来帮助去重
 */

public class PermutationsII_47 {
    public static void main(String[] args) {
        PermutationsII_47 solution = new PermutationsII_47();
        int[] nums = {1, 1, 2};
        System.out.println(solution.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(0, nums, used, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int turn, int[] nums, boolean[] used, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (turn == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTrack(turn + 1, nums, used, path, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
