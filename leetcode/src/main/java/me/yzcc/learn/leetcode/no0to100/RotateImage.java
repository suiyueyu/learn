package me.yzcc.learn.leetcode.no0to100;

/**
 * 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateImage {
    private class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int length = matrix.length;
        int xBorder;
        int yBorder;

        if (length % 2 == 0) {
            xBorder = length / 2;
            yBorder = length / 2;
        } else {
            xBorder = length / 2 + 1;
            yBorder = length / 2;
        }
        for (int y = 0; y < yBorder; y++) {
            for (int x = 0; x < xBorder; x++) {
                rotateFourPoint(matrix, y, x);
            }
        }
    }

    private Point[] getFourPointAfterRotate(Point leftTop, int length) {
        Point[] points = new Point[4];
        int x = leftTop.x;
        int y = leftTop.y;

        points[0] = leftTop;

        Point rightTop = new Point(length - 1 - y, x);
        points[1] = rightTop;

        Point rightBottom = new Point(length - 1 - x,  length - 1 - y);
        points[2] = rightBottom;

        Point leftBottom = new Point(y, length - 1 - x);
        points[3] = leftBottom;

        return points;
    }

    private void rotateFourPoint(int[][] matrix, int y, int x) {
        Point leftTop = new Point(x, y);
        Point[] fourPoint = getFourPointAfterRotate(leftTop, matrix.length);
        int tmp = matrix[fourPoint[0].y][fourPoint[0].x];
        matrix[fourPoint[0].y][fourPoint[0].x] = matrix[fourPoint[3].y][fourPoint[3].x];
        matrix[fourPoint[3].y][fourPoint[3].x] = matrix[fourPoint[2].y][fourPoint[2].x];
        matrix[fourPoint[2].y][fourPoint[2].x] = matrix[fourPoint[1].y][fourPoint[1].x];
        matrix[fourPoint[1].y][fourPoint[1].x] = tmp;
    }
}
