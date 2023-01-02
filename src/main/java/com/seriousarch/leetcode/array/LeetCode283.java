package com.seriousarch.leetcode.array;

import com.alibaba.fastjson2.JSON;

/**
 * 移动零
 * See {@linktourl https://leetcode.cn/problems/move-zeroes/}
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        // 1. 先移动所有非0的元素
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // 2. 把剩下的元素置为0
        for (int i=index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        LeetCode283 solution = new LeetCode283();
        int[] nums = {0,1,0,3,12};

        solution.moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
