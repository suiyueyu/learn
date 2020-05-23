package me.yzcc.learn.leetcode.no0to100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 通过次数50,829提交次数69,081
 */
class No77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new LinkedList<>();

        dfs(n, k, results, new LinkedList<Integer>());
        return results;
    }

    private void dfs(int n,
                     int k,
                     List<List<Integer>> results,
                     LinkedList<Integer> current) {
        if (current.size() == k) {
            LinkedList<Integer> result = new LinkedList<>(current);
            results.add(result);
            return;
        }
        int last = 0;
        if (current.size() > 0) {
            last = current.getLast();
            if (n - last < k - current.size()) {
                return;
            }
        }

        for (int i = last + 1; i <= n; i++) {
            current.addLast(i);
            dfs(n, k, results, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        No77Combinations combinations = new No77Combinations();
        System.out.println(combinations.combine(4, 2));
        System.out.println(combinations.combine(3, 3));
    }
}
