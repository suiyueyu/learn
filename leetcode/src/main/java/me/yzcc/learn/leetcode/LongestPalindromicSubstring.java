package me.yzcc.learn.leetcode;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int maxStrStart = 0;
        int maxStrEnd = 0;
        int maxStrLength = 0;

        for (int center = 0; center < s.length(); center++) {
            int length1 = findMaxSubStringLength(s, center, center);
            int length2 = findMaxSubStringLength(s, center, center+1);

            int length = Math.max(length1, length2);
            if (length > maxStrLength) {
                maxStrLength = length;
                maxStrStart = center - (length - 1) / 2;
                maxStrEnd = center + length / 2;
            }

        }

        return s.substring(maxStrStart, maxStrEnd + 1);
    }

    private int findMaxSubStringLength(String s, int left, int right) {
        int min = 0;
        int max = s.length() - 1;

        if (left < min) {
            return -1;
        }
        if (right > max) {
            return -1;
        }

        while (left >= min && right <= max && s.charAt(left) == s.charAt(right)) {
            left --;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring longest = new LongestPalindromicSubstring();
        System.out.println(longest.longestPalindrome("babad"));
        System.out.println(longest.longestPalindrome("baabad"));
    }
}
