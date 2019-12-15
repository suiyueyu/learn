package me.yzcc.learn.leetcode.no200to300;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public boolean isHappy(int n) {
        Map<Integer, Integer> numToHapperNumbers = new HashMap<>();
        int current = n;

        while (! numToHapperNumbers.containsKey(current)) {
            int happyNumber = calculateSquare(current);
            if (happyNumber == 1) {
                return true;
            }
            numToHapperNumbers.put(current, happyNumber);
            current = happyNumber;
        }

        return false;
    }

    private int calculateSquare(int n) {
        int result = 0;

        while (n != 0) {
            int part = n % 10;
            result += part * part;
            n /= 10;
        }

        return result;
    }

    /**
     * 参考最优时间答案:
     * 非快乐数最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中
     *
     * 为了省空间可以用快慢指针，一个走一步一个走两步
     * 我觉得都还ok
     *
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        return false;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        System.out.println(solution.calculateSquare(19));
    }
}
