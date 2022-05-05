package me.yzcc.learn.leetcode.no0to100;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        backtrace(results, current, 0, 0, n);

        return results;
    }

    private void backtrace(List<String> results, StringBuilder current, int open, int close, int n) {
        if (current.length() == n * 2) {
            results.add(current.toString());
        }

        if (open < n) {
             backtrace(results, current.append("("), open+1, close, n);
             current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            backtrace(results, current.append(")"), open, close+1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}