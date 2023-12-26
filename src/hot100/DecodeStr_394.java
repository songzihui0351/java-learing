package hot100;

import java.util.LinkedList;

public class DecodeStr_394 {
    public static void main(String[] args) {
        DecodeStr_394 solution = new DecodeStr_394();
        System.out.println(solution.decodeString("100[aadsfaf]"));
    }

    public String decodeString(String s) {
        LinkedList<Integer> integers = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        StringBuilder multi = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi.append(c);
            } else if (c == '[') {
                integers.addLast(Integer.parseInt(multi.toString()));
                strings.addLast(res.toString());
                res = new StringBuilder();
                multi = new StringBuilder();
            } else if (c == ']') {
                Integer m = integers.removeLast();
                String lastStr = strings.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < m; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(lastStr + tmp);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
