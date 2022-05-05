package me.yzcc.learn.leetcode.no0to100;

import sun.java2d.windows.GDIWindowSurfaceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 通过次数474,391提交次数821,540
 */
public class No17LetterCombinationsOfAPhoneNumberSolution1 {
    private static final String[] KEYBOARD_TO_LETTERS = new String[] {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", //6
            "pqrs", // 7
            "tuv", //8
            "wxyz"// 9
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        List<String> results = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrace(results, current, 0, digits);

        return results;
    }

    private void backtrace(List<String> results, StringBuilder current, int pos, String digits) {
        if (pos == digits.length()) {
            results.add(current.toString());
            return;
        }
        String letters = KEYBOARD_TO_LETTERS[digits.charAt(pos) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            backtrace(results, current.append(letters.charAt(i)), pos+1, digits);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
