package me.yzcc.learn.leetcode.no0to100;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean isFirstColumnZero = false;
        boolean isFirstRowZero = false;

        for (int i = 0; i < columns; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                setRowZero(matrix, columns, i);
            }
        }

        for (int i = 1; i < columns; i++) {
            if (matrix[0][i] == 0) {
                setColumnZero(matrix, rows, i);
            }
        }

        if (isFirstRowZero) {
            setRowZero(matrix, columns, 0);
        }

        if (isFirstColumnZero) {
            setColumnZero(matrix, rows, 0);
        }
    }

    private void setColumnZero(int[][] matrix, int size, int column) {
        for (int i = 0; i < size; i ++) {
            matrix[i][column] = 0;
        }
    }

    private void setRowZero(int[][] matrix, int size, int row) {
        for (int i = 0; i < size; i ++) {
            matrix[row][i] = 0;
        }
    }
}
