package me.yzcc.learn.leetcode.no100to200;

/**
 * 329. 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 *
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 *
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * 通过次数25,345提交次数56,733
 */
public class No200LongestIncreasingPathInAMatrix {
    private static final int[][] DIRECTIONS = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    /**
     * 用dfs深度遍历访问，思路概括的说
     * 矩阵图形，如果两个节点是递增的关系，matrix(y, x) < matrix(nextY, nextX)，
     * 那么可以认为 (y, x)到 (nextY, nextX) 有一条边。
     * 寻找一条最大的路径，等于 遍历全部节点，从这个节点出发，可以走的最大长度
     * result = Max-Path( foreach(next point: all node) )
     *
     * 对于某个节点来说，他的最大路径，等于周围四个能走的邻居出发的最大路径 +1
     * f(y, x) = Max( Math-path(foreach(next point: all incr-neighbor node)) ) + 1
     *
     * dfs的终点，是达到图形边界，或者不满足递增
     *
     * 最后是重复计算的各个邻居节点，就直接用记忆数组记下来
     * 路径大小至少为1（从自己到自己），所以初始化为0，大于0的就代表已经算过了。
     *
     * @see https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
     * 第一次写答案遇到的问题：
     * 1. 递增是严格的，matrix(y, x) < matrix(nextY, nextX)，没有等号
     * 2. dfs里面，下个方向的结果应该是 dfs(nextY, nextX) + 1，注意+1，否则就永远是1了
     */

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int result = 0;
        int rows = matrix.length; // y
        int columns = matrix[0].length; // x


        int[][] memos = new int[rows][columns];

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                result = Math.max(result, dfs(matrix, y, x, memos));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int y, int x, int[][] memos) {
        // 如果memos[y][x]算过了，则大于0
        // 至少为1，从自己到自己
        if (memos[y][x] > 0) {
            return memos[y][x];
        }

        // 自己到自己
        memos[y][x] = 1;

        for (int[] direction: DIRECTIONS) {
            int nextY = y + direction[0];
            int nextX = x + direction[1];

            if (isValidNextPoint(matrix, y, x, nextY, nextX)) {
                memos[y][x] = Math.max(memos[y][x], dfs(matrix, nextY, nextX, memos) + 1);
            }
        }
        return memos[y][x];
    }

    private boolean isValidNextPoint(int[][] matrix, int y, int x, int nextY, int nextX) {
        if (nextY < 0 || nextY >= matrix.length) {
            return false;
        }

        if (nextX < 0 || nextX >= matrix[0].length) {
            return false;
        }

        return matrix[y][x] < matrix[nextY][nextX];
    }


}