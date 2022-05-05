package me.yzcc.learn.leetcode.no1300to1400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * 示例 2：
 *
 *
 *
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 *
 *
 * 提示：
 *
 * 每棵树的节点数在 [0, 5000] 范围内
 * -105 <= Node.val <= 105
 * 通过次数23,176提交次数30,219
 */
public class No1305AllElementsInTwoBinarySearchTreesSolution2 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

         List<Integer> list1 = new ArrayList<>();
         List<Integer> list2 = new ArrayList<>();

         dfs(root1, list1);
         dfs(root2, list2);

        return merge(list1, list2);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> results = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            int le = list1.get(i);
            int ri = list2.get(j);
            if (le < ri) {
                results.add(le);
                i++;
            } else {
                results.add(ri);
                j++;
            }
        }

        if (i == list1.size()) {
            while (j < list2.size()) {
                results.add(list2.get(j));
                j++;
            }
        }

        if (j == list2.size()) {
            while (i < list1.size()) {
                results.add(list1.get(i));
                i++;
            }
        }

        return results;
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