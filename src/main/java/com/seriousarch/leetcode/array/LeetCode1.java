package com.seriousarch.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * See {@linktourl https://leetcode.cn/problems/two-sum/}
 */
public class LeetCode1 {
    /**
     * 哈希表法
     * 时间复杂度：O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            // diff 包括在当前的map里，并且，不等于当前下标
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 暴力解法
     * 时间复杂度：O(N*N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV2(int[] nums, int target) {
        int[] result = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            int current = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                int next = nums[j];
                if (current + next == target) {
                    return new int[]{i, j};
                }
            }
        }

        return result;
    }
}
