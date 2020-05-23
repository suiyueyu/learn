package me.yzcc.learn.leetcode.no0to100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 通过次数130,091提交次数171,050
 */
class No46Permutations {
    /**
     * 参考 https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new LinkedList<>();

        boolean[] isSelected = new boolean[nums.length];
        LinkedList<Integer> current = new LinkedList<>();

        dfs(nums, 0, results, isSelected, current);
        return results;
    }

    private void dfs(int[] nums,
                     int depth,
                     List<List<Integer>> results,
                     boolean[] isSelected,
                     LinkedList<Integer> current) {
        if (depth == nums.length) {
            LinkedList<Integer> newResult = new LinkedList<>(current);
            results.add(newResult);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isSelected[i]) {
                current.addLast(nums[i]);
                isSelected[i] = true;
                dfs(nums, depth+1, results, isSelected, current);
                current.removeLast();
                isSelected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        No46Permutations solution = new No46Permutations();
        int[] nums = {1,2,3};
        System.out.println(solution.permute(nums));
    }
}
