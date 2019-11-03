package me.yzcc.learn.leetcode;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        String reveredNum1 = new StringBuilder(num1).reverse().toString();
        String reveredNum2 = new StringBuilder(num2).reverse().toString();

        StringBuilder result = new StringBuilder();
        int adder = 0;

        int i = 0;
        int j = 0;

        while (i < reveredNum1.length() && j < reveredNum2.length()) {
            int curr = (reveredNum1.charAt(i) - '0') + (reveredNum2.charAt(j) - '0') + adder;
            if (curr >= 10) {
                result.append(curr - 10);
                adder = 1;
            } else {
                result.append(curr);
                adder = 0;
            }

            i++;
            j++;
        }

        while (i < reveredNum1.length()) {
            int curr = (reveredNum1.charAt(i) - '0') + adder;
            if (curr >= 10) {
                result.append(curr - 10);
                adder = 1;
            } else {
                result.append(curr);
                adder = 0;
            }
            i++;
        }

        while (j < reveredNum2.length()) {
            int curr = (reveredNum2.charAt(j) - '0') + adder;
            if (curr >= 10) {
                result.append(curr - 10);
                adder = 1;
            } else {
                result.append(curr);
                adder = 0;
            }

            i++;
            j++;
        }

        if (adder > 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings add = new AddStrings();

        System.out.println(add.addStrings("1234", "1234"));
        System.out.println(add.addStrings("9999", "9999"));
        System.out.println(add.addStrings("1", "9999"));
        System.out.println(add.addStrings("0", "9999"));
    }
}
