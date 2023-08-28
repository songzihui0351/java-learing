package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
    回溯算法: 添加 -> 回溯 -> 撤销
 */

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer> combinations = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        dfs(0, target, combinations, res, candidates);
        return res;
    }

    private static void dfs(int curr, int target, ArrayList<Integer> combinations, ArrayList<List<Integer>> res, int[] candidates) {
        if (curr == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(combinations));
            return;
        }

        dfs(curr + 1, target, combinations, res, candidates);

        if (target - candidates[curr] >= 0) {
            combinations.add(candidates[curr]);
            dfs(curr, target - candidates[curr], combinations, res, candidates);
            combinations.remove(combinations.size() - 1);
        }
    }
}
