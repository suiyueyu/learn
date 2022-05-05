package me.yzcc.learn.leetcode.no1300to1400;

import java.util.*;

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
public class No1305AllElementsInTwoBinarySearchTrees {

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
        List<Integer> elements1 = travel(root1);
        List<Integer> elements2 = travel(root2);
        List<Integer> results = new ArrayList<>(elements1);
        results.addAll(elements2);

        Collections.sort(results);

        return results;
        LinkedHashMap
    }

    private List<Integer> travel(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> results = new LinkedList<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            results.add(node.val);

            if (node.left != null) {
                list.add(node.left);
            }

            if (node.right != null) {
                list.add(node.right);
            }
        }

        return results;
    }
}