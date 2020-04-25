package me.yzcc.learn.leetcode.no0to100;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchA2dMatrix {
    /**
     * 最优解还是整体搜索
     * lo = 0, hi = n * m
     * mid = lo + (lo + hi) / 2;
     * 然后计算偏移量
     * y = mid % m;
     * x = mid / m;
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = searchMatrixRow(matrix, target);
        if (row == -1) {
            return false;
        }

        return searchMatrixColumn(matrix, row, target);
    }

    private boolean searchMatrixColumn(int[][] matrix, int row, int target) {
        int hi = matrix[row].length - 1;
        int lo = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target < matrix[row][mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    private int searchMatrixRow(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return -1;
        }

        int rows = matrix.length - 1;
        int columns = matrix[0].length - 1;
        if (target > matrix[rows][columns]) {
            return -1;
        }

        int lo = 0;
        int hi = rows;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][columns]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
