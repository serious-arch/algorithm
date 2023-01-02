package com.seriousarch.leetcode.reverse;

import com.alibaba.fastjson2.JSON;

/**
 * 整数反转
 * See {@linktourl https://leetcode.cn/problems/reverse-integer/description/}
 */
public class LeetCode7 {

    public int reverse(int x) {
        int result = 0;
        while ( x != 0) {
            // 判断是否大于最大32位整数
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) {
                return 0;
            }

            // 每次取未尾数字
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode7 solution = new LeetCode7();
        int result = solution.reverse(1534236469);
        System.out.println(JSON.toJSONString(result));
    }
}
