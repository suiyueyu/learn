package me.yzcc.learn.leetcode;

import java.util.Arrays;

/**
 * 67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    private int firstPositionNotZero(String a) {
        return a.indexOf('1');
    }

    public String addBinary(String a, String b) {
        int[] reversedA = reverse(a);
        int[] reversedB = reverse(b);

        int[] result = new int[Math.max(reversedA.length, reversedB.length) + 1];
        int i = 0;
        for (; i < reversedA.length && i < reversedB.length; i++) {
            result[i] = result[i] + reversedA[i] + reversedB[i];

        }

        for (; i < reversedA.length; i++) {
            result[i] += reversedA[i];

        }

        for (; i < reversedB.length; i++) {
            result[i] += reversedB[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < result.length - 1; j++) {
            if (result[j] > 1) {
                result[j + 1]++;
                result[j] -= 2;
            }
            sb.append(result[j]);
        }

        if (result[result.length - 1] == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    private int[] reverse(String a) {
        int begin = firstPositionNotZero(a);

        if (begin == -1) {
            return new int[]{0};
        }
        int[] result = new int[a.length() - begin];

        for (int i = 0; i < result.length; i++) {
            result[i] = a.charAt(a.length() - i - 1) - '0';
        }
        return result;
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();

        System.out.println(addBinary.addBinary("000100", "001111"));
        System.out.println(addBinary.addBinary("000000", "001111"));
        System.out.println(addBinary.addBinary("1", "11"));
        System.out.println(addBinary.addBinary("1010", "1011"));

    }
}
