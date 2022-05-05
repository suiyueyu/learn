package me.yzcc.learn.leetcode.no300to400;

import java.util.Arrays;

class No387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, -2);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (alphabet[index] == -2){
                alphabet[index] = i;
            }
            else if (alphabet[index] == -1) {

            }
            else if (alphabet[index] > -1) {
                alphabet[index] = -1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 0) {
                min = Math.min(min, alphabet[i]);
            }
        }

        return min < Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        No387FirstUniqueCharacterInAString solution = new No387FirstUniqueCharacterInAString();
        System.out.println(solution.firstUniqChar("leetcode"));;
    }
}
