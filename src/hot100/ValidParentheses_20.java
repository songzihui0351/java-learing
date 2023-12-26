package hot100;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = map.get(stack.pop());
                if (!left.equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
