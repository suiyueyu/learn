package me.yzcc.learn.leetcode.no0to100;

import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] result = new int[n][n];
        int curr = 1;
        int level = 0;

        while (curr <= n*n) {
            for (int i = level; i < n - level; i++) {
                result[level][i] = curr;
                curr++;
            }
            for (int i = level + 1; i < n - level; i ++) {
                result[i][n - 1 - level] = curr;
                curr++;
            }
            for (int i = (n - 1 - level - 1); i >= level; i--) {
                result[n-1-level][i] = curr;
                curr++;
            }
            for (int i = (n - 1 - level - 1); i > level; i--) {
                result[i][level] = curr;
                curr++;
            }
            level++;
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(SpiralMatrixII.generateMatrix(1)));
        System.out.println(Arrays.deepToString(SpiralMatrixII.generateMatrix(2)));
        System.out.println(Arrays.deepToString(SpiralMatrixII.generateMatrix(3)));
        System.out.println(Arrays.deepToString(SpiralMatrixII.generateMatrix(4)));
    }
}
