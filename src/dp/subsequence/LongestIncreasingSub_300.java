package dp.subsequence;

/*
    DP: n^2复杂度
    Greedy+BinarySearch: nlogn复杂度, 维护一个greedy数组, 只保存递增的数字, 如果是递增的则res++
 */
public class LongestIncreasingSub_300 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
//        int[] nums = {0, 1, 0, 3, 2, 3};
//        System.out.println(dp(nums));
        System.out.println(greedyBinarySearch(nums));
    }

    public static int dp(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int greedyBinarySearch(int[] nums) {
        int[] greedy = new int[nums.length];
        int end = 0, index;
        for (int num : nums) {
            index = binarySearch(greedy, num, end);
            if (index == end) {
                end++;
            }
        }
        return end;
    }

    private static int binarySearch(int[] greedy, int target, int end) {
        int left = 0, right = end;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (greedy[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        greedy[left] = target;

        return left;
    }
}
