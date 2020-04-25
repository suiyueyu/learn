package me.yzcc.learn.leetcode.no0to100;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SortColors {
    /**
     * 计数
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = 0;
        int one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero ++;
            } else if (nums[i] == 1) {
                one ++;
            }
        }

        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }
        for (int i = zero + one; i < nums.length; i++) {
            nums[i] = 2;
        }

    }

    /**
     * 3切分数组
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int curr = 0;

        while (curr <= right) {
            if (nums[curr] == 0) {
                exch(nums, left, curr);
                left ++;
                curr ++;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                exch(nums, curr, right);
                right --;
            }
        }
    }

    private void exch(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
