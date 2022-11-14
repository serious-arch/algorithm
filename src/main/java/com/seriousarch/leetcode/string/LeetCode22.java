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



    public List<String> generateParenthesisV2(int n) {
        backtrackingV2(n, 0, 0);
        return result;
    }

    StringBuilder combination = new StringBuilder();
    List<String> result = new ArrayList<>();

    private void backtrackingV2(int n, int left, int right) {
        if (combination.length() == n * 2) {
            result.add(combination.toString());
            return ;
        }

        if (left < n) {
            combination.append('(');
            backtrackingV2(n, left+1, right);
            combination.deleteCharAt(combination.length() - 1);
        }
        if (right < left) {
            combination.append(')');
            backtrackingV2(n, left, right+1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode22 solution = new LeetCode22();
        List<String> result = solution.generateParenthesisV2(3);
        System.out.println(result);
    }

}
