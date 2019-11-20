package me.yzcc.learn.leetcode;

/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] words = s.toCharArray();
        int i = 0;
        int j = words.length - 1;

        while (i < j) {
            while (isIgnored(words[i]) && i < j) {
                i ++;
            }
            while (isIgnored(words[j]) && i < j) {
                j --;
            }

            char left = words[i];
            char right = words[j];
            if (isUpperChar(left)) {
                left = (char)(left - 'A' + 'a');
            }

            if (isUpperChar(right)) {
                right = (char)(right - 'A' + 'a');
            }

            if (left != right) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    private boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isLowerChar(char c) {
        return 'a' <= c && c <= 'z';
    }

    private boolean isUpperChar(char c){
        return 'A' <= c && c <= 'Z';
    }

    private boolean isIgnored(char c) {
        return (!isNum(c)) && (!isUpperChar(c)) && (!isLowerChar(c));
    }

    public static void main(String[] args) {
        ValidPalindrome valid = new ValidPalindrome();
        System.out.println(valid.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(valid.isPalindrome(" "));
    }
}
