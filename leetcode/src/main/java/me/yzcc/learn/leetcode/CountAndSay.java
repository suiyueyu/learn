package me.yzcc.learn.leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n-1);
        char[] chars = last.toCharArray();

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char currentChar = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                count ++;
            } else {
                sb.append(count).append(currentChar);
                currentChar = chars[i];
                count = 1;
            }

            if (i == chars.length - 1) {
                sb.append(count).append(currentChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(1));
        System.out.println(c.countAndSay(4));
        System.out.println(c.countAndSay(5));
        System.out.println(c.countAndSay(6));
    }
}
