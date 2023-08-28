package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    使用 !used[i-1] 是因为: nums[i-1]和nums[i]已经相同, 如果used[i-1]为true则说明此刻的i处于i-1的内部, 所以不会产生重复
 */

public class SubsetsII_90 {
    public static void main(String[] args) {
        SubsetsII_90 solution = new SubsetsII_90();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(0, nums, used,  new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int idx, int[] nums, boolean[] used, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if (idx == nums.length) {
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(i + 1, nums, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
