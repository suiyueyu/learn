package me.yzcc.learn.leetcode;

import java.util.LinkedList;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> tree1BFS = new LinkedList<>();
        tree1BFS.addFirst(p);

        LinkedList<TreeNode> tree2BFS = new LinkedList<>();
        tree2BFS.addFirst(q);

        while (! tree1BFS.isEmpty() && ! tree2BFS.isEmpty()) {
            TreeNode node1 = tree1BFS.removeFirst();
            TreeNode node2 = tree2BFS.removeFirst();

            if (node1 == null && node2 == null) {

            } else if (node1 == null || node2 == null) {
                return false;
            } else {
                if (node1.val != node2.val) {
                    return false;
                }

                tree1BFS.addLast(node1.left);
                tree1BFS.addLast(node1.right);

                tree2BFS.addLast(node2.left);
                tree2BFS.addLast(node2.right);
            }
        }

        return true;
    }
}
