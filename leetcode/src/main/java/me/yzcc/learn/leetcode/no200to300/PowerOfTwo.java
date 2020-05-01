package me.yzcc.learn.leetcode.no200to300;

/**
 * 231. 2的幂
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1){
                count ++;
                if (count > 1) {
                    return false;
                }
            }
            n >>= 1;
        }
        return true;
    }
}
