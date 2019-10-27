package me.yzcc.learn.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String[] numsInStr = line.split(" ");
            int[] arrs = new int[numsInStr.length];
            for (int i = 0; i < numsInStr.length; i++) {
                arrs[i] = Integer.valueOf(numsInStr[i]);
            }

            int target = scanner.nextInt();
            int[] result = twoSum(arrs, target);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {

        }

    }
}
