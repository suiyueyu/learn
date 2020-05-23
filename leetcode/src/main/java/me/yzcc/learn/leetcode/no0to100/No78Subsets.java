package me.yzcc.learn.leetcode.no0to100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 通过次数89,628提交次数115,975
 */
class No78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new LinkedList<>();
        dfs(nums, results, 0, new LinkedList<>());
        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, int index, LinkedList<Integer> current) {
        results.add(new LinkedList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.addLast(nums[i]);
            dfs(nums, results, i + 1, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        No78Subsets subsets = new No78Subsets();
        System.out.println(subsets.subsets(new int[] {1, 2, 3}));
    }
}
