package Hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> combination = new ArrayList<>();
        for (int num : nums) {
            combination.add(num);
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack(0, nums.length - 1, res, combination);
        return res;
    }

    private static void backTrack(int turn, int stop, ArrayList<List<Integer>> res, ArrayList<Integer> combination) {
        if (turn == stop) {
            res.add(new ArrayList<>(combination));
            return;
        }
        for (int i = turn; i <= stop; i++) {
            Collections.swap(combination, turn, i);
            backTrack(turn + 1, stop, res, combination);
            Collections.swap(combination, i, turn);
        }
    }
}
