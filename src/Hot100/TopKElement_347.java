package Hot100;

import java.util.*;

public class TopKElement_347 {
    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        TopKElement_347 solution = new TopKElement_347();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o[1]));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (queue.size() < k) {
                queue.add(new int[]{key, value});
            } else if (value > queue.peek()[1]) {
                queue.poll();
                queue.add(new int[]{key, value});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}

