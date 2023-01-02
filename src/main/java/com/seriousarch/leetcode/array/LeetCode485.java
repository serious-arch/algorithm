package com.seriousarch.leetcode.array;

import com.alibaba.fastjson2.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 最大连续 1 的个数
 * See {@linktourl https://leetcode.cn/problems/max-consecutive-ones/}
 */
public class LeetCode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                result = Math.max(count, result);
                count = 0;
            }
        }
        return Math.max(result, count);
    }

    public static void main(String[] args) {
        LeetCode485 solution = new LeetCode485();
        int[] nums = {1,1,0,1,1,1};

        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }
}
