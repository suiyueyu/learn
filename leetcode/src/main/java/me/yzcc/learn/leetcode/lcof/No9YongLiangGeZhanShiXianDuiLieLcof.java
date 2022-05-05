package me.yzcc.learn.leetcode.lcof;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * 通过次数38,351提交次数53,580
 */
public class No9YongLiangGeZhanShiXianDuiLieLcof {


}

class CQueue {
    /**
     * 试了下，直接用 Stack，无论是插入的时候来回倒换，还是移除的时候来回倒换，时间差不多。
     * 开头用的是 Stack<Integer> 发现挺慢的，发现stack是一个vector，感觉就更慢了，但是会不会锁优化掉呢
     *
     * 看了下优化的思路，我这里是一添加，或者一删除，就来回倒换，效率比较低
     * 最优思路应该类似缓冲区/弹夹，stack1只用来添加
     * 一旦发生删除，先看stack2有没有，有的话，就是当前出的序列(队列的顺序)，先把他们用完
     * 没有的话，就把stack1里面的都倒换给stack2，倒过来以后，这些数又按照队列顺序了，然后stack2去掉最顶的一个
     * 这样写能到51ms
     */
    private LinkedList<Integer> master;
    private LinkedList<Integer> slave;

    public CQueue() {
        master = new LinkedList<>();
        slave = new LinkedList<>();
    }

    public void appendTail(int value) {
        while (! master.isEmpty()) {
            int i = master.pop();
            slave.push(i);
        }
        master.push(value);

        while (! slave.isEmpty()) {
            int i = slave.pop();
            master.push(i);
        }
    }

    public int deleteHead() {
        if (master.isEmpty()) {
            return -1;
        }
        return master.pop();
    }

    public void appendTail2(int value) {
        master.push(value);
    }

    public int deleteHead2() {
        if (slave.isEmpty()) {
            if (master.isEmpty()) {
                return -1;
            }
            while (! master.isEmpty()){
                int i = master.pop();
                slave.push(i);
            }
            return slave.pop();
        }
        return slave.pop();
    }
}