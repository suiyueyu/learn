package me.yzcc.learn.leetcode.interview;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 */
public class Problem1 {
    public boolean buddyStrings(String A, String B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() < 2) {
            return false;
        }

        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        int diffs = 0;
        int diffIndex1 = -1;
        int diffIndex2 = -1;
        int onlyOneKindChar = 0;

        for (int i = 0; i < arrA.length; i++) {
            onlyOneKindChar ^= arrA[i];

            if (arrA[i] != arrB[i]) {
                diffs ++;
                if (diffs == 1) {
                    diffIndex1 = i;
                } else if (diffs == 2) {
                    diffIndex2 = i;
                } else {
                    return false;
                }
            }
        }

        if (diffs == 2 && arrA[diffIndex1] == arrB[diffIndex2] && arrA[diffIndex2] == arrB[diffIndex1]) {
            return true;
        }

        return diffs == 0 && onlyOneKindChar == 0;
    }
}
