package Hot100;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    private static void backTrack(int start, int[] nums, ArrayList<Integer> combine, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<>(combine));
        for (int i = start; i < nums.length; i++) {
            combine.add(nums[i]);
            backTrack(i + 1, nums, combine, res);
            combine.remove(combine.size() - 1);
        }
    }
}
