package me.yzcc.learn.leetcode.no1400to1500;

import java.util.PriorityQueue;

public class No1405LongestHappyString {
    private static final class Word {
        private char ch;
        private int num;

        public Word(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Word> priorityQueue = new PriorityQueue<>((x, y) -> Integer.compare(y.num, x.num));

        if (a > 0) {
            priorityQueue.add(new Word('a', a));
        }
        if (b > 0) {
            priorityQueue.add(new Word('b', b));
        }
        if (c > 0) {
            priorityQueue.add(new Word('c', c));
        }

        StringBuilder result = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Word first = priorityQueue.remove();

            if (result.length() >= 2
                    && result.charAt(result.length() - 1) == first.ch
                    && result.charAt(result.length() - 2) == first.ch) {
                if (priorityQueue.size() >= 1) {
                    Word second = priorityQueue.remove();
                    second.num --;
                    result.append(second.ch);

                    priorityQueue.add(first);
                    if (second.num > 0) {
                        priorityQueue.add(second);
                    }
                } else {
                    break;
                }
            } else {
                result.append(first.ch);
                first.num --;
                if (first.num > 0) {
                    priorityQueue.add(first);
                }
            }
        }

        return result.toString();
    }
}