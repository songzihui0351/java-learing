package DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    递归法, 使用递归时注意终止条件
 */

public class AddParentheses_241 {

    static HashMap<String, List<Integer>> numberMap = new HashMap<>();

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        if (numberMap.containsKey(expression)) {
            return numberMap.get(expression);
        }

        boolean isNumber = true;
        for (char c : expression.toCharArray()) {
            if (isOperator(c)) {
                isNumber = false;
                break;
            }
        }
        if (isNumber) {
            res.add(Integer.parseInt(expression));
            numberMap.put(expression, res);
            return res;
        }

        for (int i = 0; i < expression.length(); i++) {
            char operator = expression.charAt(i);
            if (isOperator(operator)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (Integer leftVal : left) {
                    for (Integer rightVal : right) {
                        res.add(compute(leftVal, rightVal, operator));
                    }
                }
            }
        }
        return res;
    }

    private static Integer compute(Integer left, Integer right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
        }
        return -1;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
