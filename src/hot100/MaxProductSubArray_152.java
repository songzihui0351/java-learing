package hot100;

public class MaxProductSubArray_152 {
    public static void main(String[] args) {
        MaxProductSubArray_152 solution = new MaxProductSubArray_152();
        System.out.println(solution.maxProduct(new int[]{-3, -1, -1}));
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            res = Math.max(max, res);
        }
        return res;
    }
}
