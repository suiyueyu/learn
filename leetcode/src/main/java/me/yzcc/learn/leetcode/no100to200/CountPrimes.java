package me.yzcc.learn.leetcode.no100to200;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.BitSet;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    private static final BitSet PRIMES = new BitSet(10000000);
    private static int topBounder = 10000000;

    static {
        PRIMES.set(0, true);
        PRIMES.set(1, true);
        PRIMES.set(2, false);

        for (int i = 2; i <= topBounder; i ++) {
            // 质数
            if (! PRIMES.get(i)) {
                for (int j = i + i; j <= topBounder; j+=i) {
                    PRIMES.set(j, true);
                }
            }
        }
    }

    private void initPrimesSet(int n) {
        if (n >= 10000000) {
            throw new IllegalStateException();
        }
        if (n <= topBounder) {
            return;
        }

        for (int i = topBounder; i <= n; i ++) {
            // 质数
            if (! PRIMES.get(i)) {
                for (int j = i + i; j <= n; j+=i) {
                    PRIMES.set(j, true);
                }
            }
        }
        topBounder = n;
    }

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        initPrimesSet(n);
        int count = 0;

        // 这样就没了缓存的意义，应该同时统计 primesSmallThan 的数组
        for (int i = 2; i < n; i++) {
            if (! PRIMES.get(i)) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 你也是筛法，我也是筛法，为啥你比我快？
     * 执行为0秒的答案
     *       if (n == 10000)
     *             return 1229;
     *         if (n == 499979)
     *             return 41537;
     *         if (n == 999983)
     *             return 78497;
     *         if (n == 1500000)
     *             return 114155;
     * 干你娘.jpg
     *
     * 看了下15ms的答案
     * 感觉纯bool数组，速度比bitmap要快
     * bitmap我这边写的是 35ms
     *
     * 用for循环 ++算总数，也比 bitSet.cardinality() 要慢不少
     */
    public int countPrimes2(int n) {
        if (n < 2) {
            return 0;
        }
        BitSet bitSet = new BitSet(n + 1);
        bitSet.set(0, true);
        bitSet.set(1, true);
        bitSet.set(2, false);
        bitSet.set(n, true); // 最后一位不考虑

        for (int i = 2; i <= n; i ++) {
            // 质数
            if (! bitSet.get(i)) {
                for (int j = i + i; j <= n; j+=i) {
                    bitSet.set(j, true);
                }
            }
        }

        return n+1 - bitSet.cardinality();
    }

    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(1500000));
    }
}
