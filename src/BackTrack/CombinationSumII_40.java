package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    回溯: 先排序, 然后判断前一个和自己是否相同在去除重复的
 */

public class CombinationSumII_40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private static void backTrack(int curr, int target, int[] candidates, ArrayList<Integer> combine, ArrayList<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = curr; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            if (i > curr && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combine.add(candidates[i]);
            backTrack(i + 1, target - candidates[i], candidates, combine, res);
            combine.remove(combine.size() - 1);
        }
    }
}
