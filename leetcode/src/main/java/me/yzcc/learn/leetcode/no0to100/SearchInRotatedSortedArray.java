package me.yzcc.learn.leetcode.no0to100;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 分治+二分
        return searchInRotatedArray(nums, target, 0, nums.length - 1);
    }

    public int searchInRotatedArray(int[] nums,int target, int lo, int hi) {
        if (lo == hi) {
            return nums[lo] == target? lo : -1;
        }

        if (nums[lo] < nums[hi]) {
            return binarySearch(nums, target, lo, hi);
        }

        int mid = (hi - lo) / 2 + lo;

        int resultLeft = searchInRotatedArray(nums, target, lo, mid);
        if (resultLeft != -1) {
            return resultLeft;
        }
        return searchInRotatedArray(nums, target, mid + 1, hi);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if (target < nums[lo]) {
            return -1;
        }

        if (target > nums[hi]) {
            return -1;
        }

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

//        int[] arr1 = new int[]{1, 2, 3, 4, 5};
//        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};
//        System.out.println(solution.binarySearch(arr1, 3, 0, arr1.length - 1));
//        System.out.println(solution.binarySearch(arr1, 1, 0, arr1.length - 1));
//        System.out.println(solution.binarySearch(arr1, 4, 0, arr1.length - 1));
//        System.out.println(solution.binarySearch(arr2, 1, 0, arr2.length - 1));
//        System.out.println(solution.binarySearch(arr2, 3, 0, arr2.length - 1));
//        System.out.println(solution.binarySearch(arr2, 6, 0, arr2.length - 1));

        // 输入: nums = [4,5,6,7,0,1,2], target = 0
        int[] arr1 = new int[] {4,5,6,7,0,1,2};
        System.out.println(solution.search(arr1, 0));
        // 输入: nums = [4,5,6,7,0,1,2], target = 3
        int[] arr2 = new int[] {4,5,6,7,0,1,2};
        System.out.println(solution.search(arr2, 3));
    }
}
