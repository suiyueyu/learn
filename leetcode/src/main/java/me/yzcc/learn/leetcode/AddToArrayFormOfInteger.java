package me.yzcc.learn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 解释 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();

        int indexA = A.length - 1;
        int adder = 0;

        while (indexA >= 0 && K > 0) {
            int curr = K % 10 + A[indexA] + adder;

            if (curr >= 10) {
                result.addFirst(curr - 10);
                adder = 1;
            } else {
                result.addFirst(curr);
                adder = 0;
            }

            K /= 10;
            indexA --;
        }

        while (indexA >= 0) {
            int curr = A[indexA] + adder;
            if (curr >= 10) {
                result.addFirst(curr - 10);
                adder = 1;
            } else {
                result.addFirst(curr);
                adder = 0;
            }
            indexA --;
        }

        while (K > 0) {
            int curr = K % 10 + adder;
            if (curr >= 10) {
                result.addFirst(curr - 10);
                adder = 1;
            } else {
                result.addFirst(curr);
                adder = 0;
            }
            K /= 10;
        }

        if (adder == 1) {
            result.addFirst(1);
        }

        return result;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger add = new AddToArrayFormOfInteger();

        System.out.println(add.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(add.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(add.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(add.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }
}
