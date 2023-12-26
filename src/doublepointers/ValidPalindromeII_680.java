package doublepointers;

/*
    验证回文子串II, 在可以删除一个字符的条件下判断是否为回文子串
 */

public class ValidPalindromeII_680 {
    public static void main(String[] args) {
        String s = "cbbcc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
