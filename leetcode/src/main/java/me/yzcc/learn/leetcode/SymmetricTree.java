package me.yzcc.learn.leetcode;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> bfs = new LinkedList<>();
        LinkedList<TreeNode> reverseBfs = new LinkedList<>();
        bfs.addFirst(root.left);
        bfs.addFirst(root.right);

        reverseBfs.addFirst(root.right);
        reverseBfs.addFirst(root.left);

        while (! bfs.isEmpty()) {
            TreeNode node = bfs.removeFirst();
            TreeNode reverseOrderNode = reverseBfs.removeFirst();

            if (node == reverseOrderNode) {

            } else if (node == null || reverseOrderNode == null) {
                return false;
            } else if(node.val != reverseOrderNode.val){
                return false;
            } else {
                bfs.addFirst(node.left);
                bfs.addFirst(node.right);
                reverseBfs.addFirst(reverseOrderNode.right);
                reverseBfs.addFirst(reverseOrderNode.left);
            }
        }

        return true;
    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val;
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;


        System.out.println(symmetricTree.isSymmetric(treeNode1));
    }
}
