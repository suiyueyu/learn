package me.yzcc.learn.leetcode;

import java.util.*;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Collections.singletonList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }

        for (int line = 2; line < numRows; line++) {
            List<Integer> lastLine = result.get(line - 1);
            ArrayList<Integer> currentLine = new ArrayList<>(line + 1);

            currentLine.add(1);
            for (int i = 0; i < lastLine.size() - 1; i++) {
                currentLine.add(lastLine.get(i) + lastLine.get(i+1));
            }
            currentLine.add(1);

            result.add(currentLine);
        }

        return result;
    }
}
