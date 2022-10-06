package com.seriousarch.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * See {@linktourl https://leetcode.cn/problems/generate-parentheses/}
 */
public class LeetCode22 {
    /**
     * 回溯法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private void backtracking(int n, List<String> result, int left, int right, String str) {
        // 不符合条件
        if (right > left) {
            return ;
        }

        // 结束
        if (left == n && right == n) {
            result.add(str);
        }

        // 加左括号
        if (left < n) {
            backtracking(n, result, left+1, right, str + "(");
        }

        if (right < left) {
            backtracking(n, result, left, right+1, str + ")");
        }
    }

    public static void main(String[] args) {
        LeetCode22 solution = new LeetCode22();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

}
