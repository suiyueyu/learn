package me.yzcc.learn.leetcode.no0to100;

import java.util.Arrays;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeIntervals {

    private class Interval {
        int left;
        int right;
        Interval next;

        Interval(int[] interval) {
            this.left = interval[0];
            this.right = interval[1];
            this.next = null;
        }

        boolean canMerge(Interval that) {
            return that.left <= this.right;
        }

        void merge(Interval that) {
            this.right = Math.max(this.right, that.right);
        }
    }


    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[0], y[0]);
        });

        Interval head = new Interval(intervals[0]);
        Interval current = head;
        int size = 1;

        for (int i = 1; i < intervals.length; i++) {
            Interval newInterval = new Interval(intervals[i]);
            if (current.canMerge(newInterval)) {
                current.merge(newInterval);
            } else {
                current.next = newInterval;
                current = current.next;
                size++;
            }
        }

        return toResult(head, size);
    }

    private int[][] toResult(Interval head, int size) {
        int[][] result = new int[size][2];
        Interval curr = head;
        for (int i = 0; i < size; i++) {
            result[i][0] = curr.left;
            result[i][1] = curr.right;
            curr = curr.next;
        }
        return result;
    }

    /**
     * 参考答案，这次就不用list，直接用null留坑，然后复制到新数组
     *
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[0], y[0]);
        });

        int barrier = 0;
        int size = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[barrier][1]) {
                intervals[barrier][1] = Math.max(intervals[barrier][1], intervals[i][1]);
                intervals[i] = null;
            }
            else {
                barrier = i;
                size++;
            }
        }

        int[][] result = new int[size][2];
        int j = 0;

        for (int[] interval : intervals) {
            if (interval == null) {
                continue;
            }
            result[j][0] = interval[0];
            result[j][1] = interval[1];
            j++;
        }

        return result;
    }

    /**
     * 又看了下时间为2ms的解法 https://leetcode-cn.com/submissions/detail/40110948/
     * 结果没有要求有序，所以
     * 输入 {1, 3}, {2, 6}, {8, 10}, {15, 18}
     * 结果:
     * [[8,10],[15,18],[1,6]]
     * [[1,6],[8,10],[15,18]]
     * 都是正确答案
     * 2ms的答案就是暴力的i, j=i+1，尽量两两合并，并往右放
     * 最后用过的左边就不再考虑了。
     * 总感觉这个能这么快，还是输入不是很大。很神奇，为啥这么快。
     */
    public int[][] merge3(int[][] intervals) {
        return null;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] input1 = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        int[][] input2 = {
                {1, 4}, {4, 5}
        };
        System.out.println(Arrays.deepToString(solution.merge2(input1)));
        System.out.println(Arrays.deepToString(solution.merge2(input2)));
    }
}
