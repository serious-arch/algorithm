package com.seriousarch.leetcode.stack;

import java.util.Stack;

/**
 * 有效的括号
 * See {@linktourl https://leetcode.cn/problems/valid-parentheses/}
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (ch == ')' && top != '(') {
                        return false;
                    }
                    if (ch == ']' && top != '[') {
                        return false;
                    }
                    if (ch == '}' && top != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode20 solution = new LeetCode20();
        String s = "()";
        boolean result = solution.isValid(s);
        System.out.println(result);
    }
}
