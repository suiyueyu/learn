package me.yzcc.learn.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();

        for (int indexA = 0; indexA < nums.length - 2 ; indexA ++) {
            int left = nums[indexA];

            int lo = indexA + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int threeSum = nums[lo] + nums[hi] + left;

                int mid = (hi - lo) / 2 + lo;

                if (threeSum == 0) {
                    List<Integer> result = new LinkedList<>();
                    result.add(left);
                    result.add(nums[lo]);
                    result.add(nums[hi]);
                    results.add(result);
                    lo ++;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo ++;
                    }
                    hi --;
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi --;
                    }
                } else if (threeSum < 0) {
                    lo ++;
//                    lo = mid ;

                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo ++;
                    }
                } else {
                    hi --;
//                    hi = mid - 1;
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi --;
                    }
                }
            }

            while (indexA < nums.length - 2 && nums[indexA] == nums[indexA + 1]) {
                indexA ++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        // todo: better solution? 一个一个推慢，考虑二分？
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        // todo: 考虑如何推坐标
        System.out.println(solution.threeSum(new int[] {-2, 0, 1, 1, 2}));
        System.out.println(solution.threeSum(new int[] {-4, 2, 2, 2, 2, 2, 2}));
        System.out.println(solution.threeSum(new int[] {0, 0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[] {-2, -2, -2, -2, -2, 4}));
        System.out.println(solution.threeSum(new int[] {-19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        // 二分跳的话，这个就没了
        System.out.println(solution.threeSum(new int[] {-1, -1, 0, 1}));

    }
}
