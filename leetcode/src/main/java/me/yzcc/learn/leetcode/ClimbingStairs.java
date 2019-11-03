package me.yzcc.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbingStairs {
    private static Map<Integer, Integer> stairToStep = new HashMap<>();
    public int climbStairs2(int n) {
        if(n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (stairToStep.containsKey(n)) {
            return stairToStep.get(n);
        }

        int stairToStepsMinus1 = climbStairs(n-1);
        int staitToStepsMinus2 = climbStairs(n-2);

        int result = stairToStepsMinus1 + staitToStepsMinus2;
        stairToStep.put(n, result);
        return result;
    }

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int stairMinus1 = 1;
        int stairMinus2 = 1;

        for (int i = 2; i < n; i++) {
            int next = stairMinus1 + stairMinus2;
            stairMinus1 = stairMinus2;
            stairMinus2 = next;
        }
        return stairMinus1 + stairMinus2;
    }


    public static void main(String[] args) {
        ClimbingStairs climb = new ClimbingStairs();
        System.out.println(climb.climbStairs(2));
        System.out.println(climb.climbStairs(3));
        System.out.println(climb.climbStairs(4));
        System.out.println(climb.climbStairs(5));
    }
}
