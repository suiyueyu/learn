package me.yzcc.learn.leetcode.no300to400;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        int lo = 0;
        int hi = num;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            int div = num / mid;
            if (div == mid && div * mid == num) {
                return true;
            } else if (div < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare solution = new ValidPerfectSquare();
        System.out.println(solution.isPerfectSquare(5));
        System.out.println(solution.isPerfectSquare(6));
        System.out.println(solution.isPerfectSquare(7));
        System.out.println(solution.isPerfectSquare(8));
        System.out.println(solution.isPerfectSquare(9));
        System.out.println(solution.isPerfectSquare(10));
        System.out.println(solution.isPerfectSquare(11));
        System.out.println(solution.isPerfectSquare(12));
        System.out.println(solution.isPerfectSquare(13));
        System.out.println(solution.isPerfectSquare(14));
        System.out.println(solution.isPerfectSquare(15));
        System.out.println(solution.isPerfectSquare(16));

    }
}
