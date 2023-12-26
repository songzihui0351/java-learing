package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    回溯:
        需要列出所有可能 -> for循环, 会有重复的
        不需要重复 -> 不用for循环, 看是否需要这个数(类似于01背包)
 */

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backTrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private static void backTrack(int curr, int target, int[] candidates, ArrayList<Integer> combine, ArrayList<List<Integer>> res) {
        if (curr >= candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        backTrack(curr + 1, target, candidates, combine, res);
        if (target - candidates[curr] >= 0) {
            combine.add(candidates[curr]);
            backTrack(curr, target - candidates[curr], candidates, combine, res);
            combine.remove(combine.size() - 1);
        }
    }
}
