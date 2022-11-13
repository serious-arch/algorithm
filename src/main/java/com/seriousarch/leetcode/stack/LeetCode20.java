package com.seriousarch.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 * See {@linktourl https://leetcode.cn/problems/valid-parentheses/}
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char previous = stack.pop();

                if (previous != '(' && c == ')') {
                    return false;
                }
                if (previous != '[' && c == ']') {
                    return false;
                }
                if (previous != '{' && c == '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 solution = new LeetCode20();
        String s = "(())";
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}
