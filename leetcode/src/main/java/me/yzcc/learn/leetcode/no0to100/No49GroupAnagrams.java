package me.yzcc.learn.leetcode.no0to100;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        Map<String, List<String>> sortedWordToWords = new HashMap<>();
        for (String str: strs) {
            char[] sortedChars = str.toCharArray();
            Arrays.sort(sortedChars);

            // 这里用 String.valueOf 替换 new String，能从 9ms -> 8ms
            String sortedWord = String.valueOf(sortedChars);

            if (!sortedWordToWords.containsKey(sortedWord)) {
                sortedWordToWords.put(sortedWord, new ArrayList<>());
            }

            sortedWordToWords.get(sortedWord).add(str);
        }
        return new ArrayList<>(sortedWordToWords.values());
    }

    public static void main(String[] args) {
        No49GroupAnagrams solution = new No49GroupAnagrams();
        List<List<String>> result = solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }
}
