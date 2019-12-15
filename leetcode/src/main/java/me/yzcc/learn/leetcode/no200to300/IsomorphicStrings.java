package me.yzcc.learn.leetcode.no200to300;

import java.util.*;

/**
 * 205. 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        Set<Character> usedChars = new HashSet<>();
        boolean[] visited = new boolean[s.length()];

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsS.length; i ++) {
            if (!visited[i]) {
                char from = charsS[i];
                char to = charsT[i];

                if (usedChars.contains(to)) {
                    return false;
                }

                for (int j = i; j < charsS.length; j++) {
                    if (! visited[j] && charsS[j] == from) {
                        if (charsT[j] != to) {
                            return false;
                        }
//                        charsS[j] = to;
                        visited[j] = true;
                    }
                }

                usedChars.add(to);
            }
        }

        return true;
    }

    // 执行用例3ms的答案,假设s中的字符只有128种
    // 这个方法和那种用 indexOf 也是一回事
    // https://leetcode-cn.com/problems/isomorphic-strings/solution/javake-neng-bi-jiao-jian-dan-de-xie-fa-by-hao-fei-/
    public boolean isIsomorphic2(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int[] lastPositionS = new int[128];
        for (int i = 0; i < lastPositionS.length; i++) {
            lastPositionS[i] = -1;
        }

        int[] lastPositionT = new int[128];
        for (int i = 0; i < lastPositionT.length; i++) {
            lastPositionT[i] = -1;
        }

        for (int i = 0; i < charsS.length; i++) {
            if (lastPositionS[charsS[i]] != lastPositionT[charsT[i]]){
                return false;
            }

            if (lastPositionS[charsS[i]] == -1) {
                lastPositionS[charsS[i]] = i;
                lastPositionT[charsT[i]] = i;
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }
}


