package me.yzcc.learn.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();
        inOrderTraversal(root, result);

        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            inOrderTraversal(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            inOrderTraversal(root.right, result);
        }
    }

    /**
     * 用栈
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();
        inOrderTraversalByStack(root, result);

        return result;
    }

    private void inOrderTraversalByStack(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (node != null || ! stack.isEmpty()){
            while (node!= null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            result.add(node.val);

            node = node.right;
        }
    }

}
