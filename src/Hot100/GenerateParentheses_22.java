package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
    dp: 看n的问题能否转化为n-1的子问题!!!
        ( 内部 ) + 外部 = 内部 + 当前 + 外部

    括号数量: 左边剩余括号一定大于右边的剩余括号!
 */

public class GenerateParentheses_22 {
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesisDP(3));
    }

    public static List<String> generateParenthesis(int n) {
        getParenthesis("", n, n);
        return res;
    }

    public static void getParenthesis(String curr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curr);
            return;
        }
        if (left == right) {
            getParenthesis(curr + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                getParenthesis(curr + "(", left - 1, right);
            }
            getParenthesis(curr + ")", left, right - 1);
        }
    }


    public static List<String> generateParenthesisDP(int n) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<String>() {{
            add("");
        }});
        ans.add(new ArrayList<String>() {{
            add("()");
        }});
        for (int i = 2; i <= n; i++) {
            ArrayList<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                ArrayList<String> inner = ans.get(j); //内部有j对
                ArrayList<String> outer = ans.get(i - j - 1); //外部有i-j-1对
                for (String s1 : inner) {
                    for (String s2 : outer) {
                        String s = "(" + s1 + ")" + s2; //再加上第i对, 一共是i对
                        curr.add(s);
                    }
                }
            }
            ans.add(curr);
        }
        return ans.get(n);
    }
}
