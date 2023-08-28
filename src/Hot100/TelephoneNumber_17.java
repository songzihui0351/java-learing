package Hot100;

import java.util.*;

/*
    注意for循环的终止条件: 一定要使用常量! 如果调用函数可能会死循环!
        for (i = 0, i < n, i++)
        for (i = 0, i < queue.size(), i++) 这样每次都会调用queue.size()来判断
 */

public class TelephoneNumber_17 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        HashMap<Character, String[]> map = new HashMap<Character, String[]>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};

        Queue<String> queue = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            add2queue(queue, map.get(c));
        }
        res.addAll(queue);
        return res;
    }

    private static void add2queue(Queue<String> queue, String[] letters) {
        int size = queue.size();
        if (size == 0) {
            queue.addAll(Arrays.asList(letters));
        } else {
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String letter : letters) {
                    queue.add(poll + letter);
                }
            }
        }
    }
}