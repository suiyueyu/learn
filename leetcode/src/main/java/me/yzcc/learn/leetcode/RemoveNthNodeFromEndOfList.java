package me.yzcc.learn.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthNodeFather = null;
        ListNode nthNode = head;
        ListNode current = head;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        while (current != null) {
            current = current.next;
            if (nthNodeFather == null) {
                nthNodeFather = nthNode;
            } else {
                nthNodeFather = nthNodeFather.next;
            }
            nthNode = nthNode.next;
        }

        // delete head
        if (nthNodeFather == null) {
            return head.next;
        } else {
            nthNodeFather.next = nthNodeFather.next.next;
        }
        return head;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode nthNodeFather = fakeHead;
        ListNode current = head;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        while (current != null) {
            current = current.next;
            nthNodeFather = nthNodeFather.next;
        }


        nthNodeFather.next = nthNodeFather.next.next;

        return nthNodeFather.next;
    }
}
