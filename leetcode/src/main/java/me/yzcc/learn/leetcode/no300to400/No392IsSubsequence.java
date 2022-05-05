package me.yzcc.learn.leetcode.no300to400;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢:
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 * 通过次数76,322提交次数151,553
 */
public class No392IsSubsequence {
    /**
     * @see https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
     * 双指针的思路：
     * 如下图开始
     * ↓
     * a x c
     * a h b g d c
     * ↑
     *
     * 下个状态，这里x和h不匹配，动长串的指针，往后找
     *   ↓
     * a x c
     * a h b g d c
     *   ↑
     *
     *
     * 这样一直往后找，这个例子里面，长串的指针会走到终点结束
     *   ↓
     * a x c
     * a h b g d c
     *     ↑
     *
     * 匹配成功的场景应该如下所示，
     * 此时短串的字符都已经匹配，走到边界退出，短串的指针走到 s.length
     *       ↓
     * a x c
     * a h x g d c
     *             ↑
     *
     * @param s 短串
     * @param t 长串
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
