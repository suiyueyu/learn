package me.yzcc.learn.leetcode;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
            char current = strs[0].charAt(charIndex);
            for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
                if (strs[wordIndex].charAt(charIndex) != current) {
                    return sb.toString();
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"flower", "flow", "flight"};
        String[] words2 = new String[]{"dog", "racecar", "car"};
        String[] words3 = new String[]{"c", "c"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(words));
        System.out.println(longestCommonPrefix.longestCommonPrefix(words2));
        System.out.println(longestCommonPrefix.longestCommonPrefix(words3));
    }
}
