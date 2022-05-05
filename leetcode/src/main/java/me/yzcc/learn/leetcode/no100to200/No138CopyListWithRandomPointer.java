package me.yzcc.learn.leetcode.no100to200;

/**
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 *
 * 提示：
 *
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。
 * 通过次数146,690提交次数219,153
 */
public class No138CopyListWithRandomPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 1. 使用map记录新旧节点映射关系
     * 先建立新链表的节点
     * 然后建立random，旧random直接从map里找到新random
     * 稍微吃点空间，速度很快
     *
     * 2. interwave？
     * 提示里给出的解法
     * 思路是，把新旧节点的映射关系，用链表交织的方式实现
     * 1 -> 1' -> 2 -> 2' -> xxxx
     * 那就分三步
     * 1. 遍历旧链表，建立新链表
     * 2. 遍历交织链表，建立random，newRandom是旧random的next，记住考虑null情况
     * 3. 拆开两个链表
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            Node newNode = new Node(head.val);
            if (head.random == head) {
                newNode.random = newNode;
            }
            newNode.next = null;
            return newNode;

        }

        Node oldCurrent = head;
        Node oldNext = null;
        Node newCurrent = null;

        // build new link
        while (oldCurrent != null) {
            newCurrent = new Node(oldCurrent.val);
            oldNext = oldCurrent.next;

            newCurrent.next = oldNext;
            oldCurrent.next = newCurrent;

            oldCurrent = oldNext;
        }

        Node newHead = head.next;


        // build new random link
        oldCurrent = head;

        Node oldRandom = null;
        Node newRandom = null;

        while (oldCurrent != null) {
            newCurrent = oldCurrent.next;

            oldRandom = oldCurrent.random;
            if (oldRandom != null) {
                newRandom = oldRandom.next;
                newCurrent.random = newRandom;
            } else {
                newCurrent.random = null;
            }

            oldCurrent = newCurrent.next;
        }

        // split old/new links
        Node newNext = null;
        oldCurrent = head;
        while (oldCurrent != null) {
            newCurrent = oldCurrent.next;
            oldNext = newCurrent.next;

            if (oldNext == null) {
                newNext = null;
            } else {
                newNext = oldNext.next;
            }
            oldCurrent.next = oldNext;
            newCurrent.next = newNext;

            oldCurrent = oldNext;
        }

        return newHead;
    }
}