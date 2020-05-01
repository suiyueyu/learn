package me.yzcc.learn.leetcode.no300to400;

import java.util.Stack;

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SumOfTwoIntegers {
    /**
     * 主要思路是大数相加, 这个做法处理不了负数
     * 估计也可以，可能把补码啥的搞下
     *
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
//        if (a < 0) {
//            a = (~a + 1);
//        }
//
//        if (b < 0) {
//            b = (~b + 1);
//        }
        Stack<Integer> sumStack = new Stack<>();
        sumStack.push(0);

        while (a != 0 && b != 0) {
            int lastA = a & 1;
            int lastB = b & 1;
            int adder = sumStack.pop();

            // 懒得算了
            int binarySum = lastA + lastB + adder;
            if (binarySum == 0) {
                sumStack.push(0);
                sumStack.push(0);
            } else if (binarySum == 1) {
                sumStack.push(1);
                sumStack.push(0);
            } else if (binarySum == 2) {
                sumStack.push(0);
                sumStack.push(1);
            } else {
                sumStack.push(1);
                sumStack.push(1);
            }
            a >>= 1;
            b >>= 1;
        }

        while (a != 0) {
            int last = a & 1;
            int adder = sumStack.pop();
            int binarySum = last + adder;
            if (binarySum == 0) {
                sumStack.push(0);
                sumStack.push(0);
            } else if (binarySum == 1) {
                sumStack.push(1);
                sumStack.push(0);
            } else if (binarySum == 2) {
                sumStack.push(0);
                sumStack.push(1);
            }
            a >>= 1;
        }

        while (b != 0) {
            int last = b & 1;
            int adder = sumStack.pop();
            int binarySum = last + adder;
            if (binarySum == 0) {
                sumStack.push(0);
                sumStack.push(0);
            } else if (binarySum == 1) {
                sumStack.push(1);
                sumStack.push(0);
            } else if (binarySum == 2) {
                sumStack.push(0);
                sumStack.push(1);
            }
            b >>= 1;
        }

        return toOcter(sumStack);
    }

    private int toOcter(Stack<Integer> sumStack) {
        int result = 0;
        while (! sumStack.isEmpty()) {
            result = result << 1 | sumStack.pop();
        }
        return result;
    }

    /**
     * https://leetcode-cn.com/problems/sum-of-two-integers/solution/wei-yun-suan-xiang-jie-yi-ji-zai-python-zhong-xu-y/
     */
    public int getSum2(int a, int b) {
        while (b != 0) {
            int adder = (a & b) << 1;
            a = a ^ b;
            b = adder;
        }
        return a;
    }


        public static void main(String[] args) {
//        Stack<Integer> sum = new Stack<>();
//        sum.push(1);
//        sum.push(0);
//        sum.push(0);
//        sum.push(1);

        SumOfTwoIntegers solution = new SumOfTwoIntegers();
//        System.out.println(solution.toOcter(sum));

//        System.out.println(solution.getSum(1, 2));

        //todo: 负数
        // 看了答案，艹了
        // 看下异或 -> 相加，但没有进位
        // 看下与 -> 进位
//        System.out.println(solution.getSum(-2, 3));

            System.out.println(solution.getSum2(2, 3));
            System.out.println(solution.getSum2(-2, 3));

    }
}
