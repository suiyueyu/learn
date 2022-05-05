package me.yzcc.learn.leetcode.no1300to1400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 * 通过次数23,176提交次数30,219
 */
public class No1305AllElementsInTwoBinarySearchTreesSolution3 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        LinkedList<Integer> list1 = new LinkedList<>();
        List<Integer> results = new ArrayList<>();

        dfs(root1, list1);
        dfsSecond(root2, list1, results);

        results.addAll(list1);

        return results;
    }

    private void dfsSecond(TreeNode root, LinkedList<Integer> list1, List<Integer> results) {
        if (root == null) {
            return;
        }
        dfsSecond(root.left, list1, results);
        while (list1.size() > 0 && list1.getFirst() < root.val) {
            results.add(list1.removeFirst());
        }
        results.add(root.val);
        dfsSecond(root.right, list1, results);

    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }


}