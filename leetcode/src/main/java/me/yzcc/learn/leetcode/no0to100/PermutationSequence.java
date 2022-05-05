package me.yzcc.learn.leetcode.no0to100;

import java.util.LinkedList;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> numbers = buildNumbers();
        LinkedList<Integer> factorials = buildFactorials(n);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            int factorial = factorials.removeFirst();
            if (factorial == 1) {
                result.append(numbers.remove(0));
            } else {
                int part = k / factorial;
                k = k % factorial;
                result.append(numbers.remove(part));
            }
        }

        result.append(numbers.remove(0));

        return result.toString();
    }

    private LinkedList<Integer> buildNumbers() {
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1 ; i < 10; i++) {
            numbers.addLast(i);
        }
        return numbers;
    }

    private LinkedList<Integer> buildFactorials(int n) {
        LinkedList<Integer> factorials = new LinkedList<>();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
            factorials.addFirst(factorial);
        }
        return factorials;
    }

    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        System.out.println(solution.getPermutation(1, 1));
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
        // todo
    }
}
