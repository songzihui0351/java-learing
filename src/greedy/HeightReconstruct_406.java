package greedy;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Greed:
    一般一对数字的都需要排序, 往往一个正序一个倒叙

    按照升高从高到低和人数从低到高进行插入
    插入的位置就前面人的数量, 因为前面插入的都比当期身高高, 所以按照人数直接插入即可

    Java:
    1.new int[0]的目的是房子编译器报错, 否则会要求初始化数组大小
    2.ArrayList的add操作可以按索引插入
 */

public class HeightReconstruct_406 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }

    public static int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(people, (p1, p2) -> (p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]));
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[0][]);
    }
}
