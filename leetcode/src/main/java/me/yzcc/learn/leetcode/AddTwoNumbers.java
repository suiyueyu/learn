package me.yzcc.learn.leetcode;

import java.util.Scanner;

/**
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        ListNode result = new ListNode(0);
        ListNode resultCurr = result;

        while(l1Curr != null && l2Curr != null) {
            int sum = resultCurr.val + l1Curr.val + l2Curr.val;
            resultCurr.val = sum % 10;

            if (sum >= 10) {
                resultCurr.next = new ListNode(1);
            } else if (l1Curr.next == null && l2Curr.next == null){
                resultCurr.next = null;
            } else {
                resultCurr.next = new ListNode(0);
            }

            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
            resultCurr = resultCurr.next;
        }

        while (l1Curr != null) {
            resultCurr.val += l1Curr.val;

            if (resultCurr.val >= 10) {
                resultCurr.next = new ListNode(1);
                resultCurr.val %= 10;
            } else if (l1Curr.next != null){
                resultCurr.next = new ListNode(0);
            }

            l1Curr = l1Curr.next;
            resultCurr = resultCurr.next;
        }

        while (l2Curr != null) {
            resultCurr.val += l2Curr.val;

            if (resultCurr.val >= 10) {
                resultCurr.next = new ListNode(1);
                resultCurr.val %= 10;
            } else if (l2Curr.next != null){
                resultCurr.next = new ListNode(0);
            }
            l2Curr = l2Curr.next;
            resultCurr = resultCurr.next;
        }

        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine().trim();
            String reverseInput = new StringBuilder(input).reverse().toString();

        }
    }
}
