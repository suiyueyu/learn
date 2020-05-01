package me.yzcc.learn.leetcode.no200to300;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsDuplicateII {
    /**
     * 执行结果：通过 显示详情
     * 执行用时 : 1393 ms , 在所有 Java 提交中击败了15.54%的用户
     * 内存消耗 : 42.6 MB , 在所有 Java 提交中击败了31.43%的用户
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length && (j - i) <= k ; j++) {
                int right = nums[j];
                if (left == right) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 执行结果：通过 显示详情
     * 执行用时 : 9 ms, 在所有 Java 提交中击败了95.01%的用户
     * 内存消耗 : 46 MB, 在所有 Java 提交中击败了5.72%的用户
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (valueToIndex.containsKey(num)) {
                int lastIndex = valueToIndex.get(num);
                if (i - lastIndex <= k) {
                    return true;
                }

            }
            valueToIndex.put(num, i);
        }
        return false;
    }
}
