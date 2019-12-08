package me.yzcc.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {
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

    // 参考 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        LinkedList<StringBuilder> builders = new LinkedList<>();
        builders.add(new StringBuilder());

        for (char ch: digits.toCharArray()) {
            String letters = KEYBOARD_TO_LETTERS[ch - '0'];

            int currentSize = builders.size();

            for (int i = 0; i < currentSize; i++) {
                StringBuilder part = builders.removeFirst();

                for (char letter : letters.toCharArray()) {
                    StringBuilder newPart = new StringBuilder(part);
                    newPart.append(letter);
                    builders.addLast(newPart);
                }
            }
        }

        List<String> result = new LinkedList<>();
        for (StringBuilder sb: builders) {
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();

        System.out.println(solution.letterCombinations(""));
    }
}
