package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Java sort:
        1.数组不带比较器时可以直接使用, 带比较器需要将基本类型转化为引用类型
        2.Comparable: 比较接口, 类需要实现compareTo方法, 这个类以后一直可以排序
        3.Comparator: 比较器, 自定义比较器, 类不需要实现Comparable接口, 在排序时传入比较器即可
 */

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1, k = length - 1;
            while (j < k) {
                if (nums[j] > 0) {
                    break;
                }
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    j++;
                    continue;
                }
                if (k < length - 1 && nums[k + 1] == nums[k]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }
}
