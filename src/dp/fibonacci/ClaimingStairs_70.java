package dp.fibonacci;

/*
    DP: 和贪心不一样的地方在于, DP的目的是用空间换时间, 将重复计算的结果存在内存中
        本题因为只和前两个值有关, 所以不需要将所有结果都存起来, 只需要记录前两个就可以
 */
public class ClaimingStairs_70 {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1, pre2 = 2, curr = 0;
        for (int i = 2; i < n; i++) {
            curr = pre1 + pre2;
            pre1 = pre2;
            pre2 = curr;
        }
        return curr;
    }
}
