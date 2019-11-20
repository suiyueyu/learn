package me.yzcc.learn.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);

        while (true) {
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> currLevelVals = new LinkedList<>();

            while (! currLevel.isEmpty()) {
                TreeNode node = currLevel.removeFirst();

                currLevelVals.add(node.val);

                if (node.left != null) {
                    nextLevel.addLast(node.left);
                }
                if (node.right != null) {
                    nextLevel.addLast(node.right);
                }
            }
            result.addFirst(currLevelVals);

            if (nextLevel.isEmpty()) {
                break;
            }
            currLevel = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
    }
}
