package me.yzcc.learn.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInteger {
    public int reverse(int x) {
        LinkedList<Integer> list = toList(x);

        return reverseInteger(list);
    }

    private int reverseInteger(LinkedList<Integer> list) {
        int result = 0;
        int upperBound = Integer.MAX_VALUE / 10;
        int lowerBound = Integer.MIN_VALUE / 10;

        while (! list.isEmpty()) {
            if (result <= upperBound && result >= lowerBound) {
                result = result * 10 + list.removeFirst();
            } else {
                return 0;
            }
        }

        return result;
    }

    private LinkedList<Integer> toList(int x) {
        LinkedList<Integer> list = new LinkedList<>();

        while (x != 0) {
            list.addLast(x % 10);
            x /= 10;
        }

        return list;
    }

    private static final int LOWER_BOUND = Integer.MIN_VALUE / 10;
    private static final int UPPER_BOUND = Integer.MAX_VALUE / 10;

    public int reverse2(int x) {
        int result = 0;
        if (x > 0) {
            while (x != 0) {
                if (result > UPPER_BOUND) {
                    return 0;
                }
                result = result * 10 + x % 10;
                x /= 10;
            }
        } else {
            while (x != 0) {
                if (result < LOWER_BOUND) {
                    return 0;
                }
                result = result * 10 + x % 10;
                x /= 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse2(123));
        System.out.println(reverseInteger.reverse2(-123));
        System.out.println(reverseInteger.reverse2(120));
        System.out.println(reverseInteger.reverse2(1999999999));
        System.out.println(reverseInteger.reverse2(-1999999999));
    }
}
