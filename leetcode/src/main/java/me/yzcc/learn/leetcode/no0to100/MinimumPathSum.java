package me.yzcc.learn.leetcode.no0to100;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int columns = grid[0].length;
        int rows = grid.length;

        int[][] dp = buildDpMatrix(grid);

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][columns-1];
    }

    private int[][] buildDpMatrix(int[][] grid) {
        int columns = grid[0].length;
        int rows = grid.length;

        int[][] dp = new int[rows][];
        for (int i = 0; i < rows; i++) {
            dp[i] = new int[columns];
        }

        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        return dp;
    }
}
