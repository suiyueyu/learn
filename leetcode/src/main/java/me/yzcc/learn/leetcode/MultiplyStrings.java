package me.yzcc.learn.leetcode;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String reverseNum1 = new StringBuilder(num1).reverse().toString();
        String reverseNum2 = new StringBuilder(num2).reverse().toString();

        int[] resultArray = new int[reverseNum1.length() + reverseNum2.length()];

        for (int i = 0; i < reverseNum1.length(); i++) {
            for (int j = 0; j < reverseNum2.length(); j++) {
                resultArray[i+j] += (reverseNum1.charAt(i) - '0') * (reverseNum2.charAt(j) - '0');
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i] >= 10) {
                resultArray[i+1] += resultArray[i] / 10;
                resultArray[i] = resultArray[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        int begin = resultArray.length - 1;
        while (begin > 0) {
            if (resultArray[begin] != 0) {
                break;
            }
            begin --;
        }

        for (int i = begin; i >= 0; i--) {
            sb.append(resultArray[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings multiply = new MultiplyStrings();

        System.out.println(multiply.multiply("2", "3"));
        System.out.println(multiply.multiply("123", "456"));
        System.out.println(multiply.multiply("0", "456"));
    }
}
