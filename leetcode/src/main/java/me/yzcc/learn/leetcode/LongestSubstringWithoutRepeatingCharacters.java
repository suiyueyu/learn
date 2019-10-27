package me.yzcc.learn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> charToPosition = new HashMap<>();

        int result =0;

        for (int left = 0, right = 0; left < n && right < n; ) {
            if (n - left < result) {
                return result;
            }

            char currChar = s.charAt(right);

            if (charToPosition.containsKey(currChar)) {
                left = Math.max(left, charToPosition.get(currChar) + 1);
            }

            result = Math.max(result, right - left + 1);
            charToPosition.put(currChar, right);
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));

        System.out.println(lengthOfLongestSubstring("abcabcabcabcd"));
        System.out.println(lengthOfLongestSubstring("abcabcabcabc"));
        System.out.println(lengthOfLongestSubstring("abcabcabcab"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
