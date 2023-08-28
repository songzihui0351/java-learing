package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        Subsets_78 solution = new Subsets_78();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int idx, int[] nums, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backTrack(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}
