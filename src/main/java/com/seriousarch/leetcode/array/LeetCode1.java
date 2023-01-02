package com.seriousarch.leetcode.array;

import com.alibaba.fastjson2.JSON;

import java.util.*;

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

    /**
     * 双指针法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{i, map.get(diff)};
            } else {
                map.put(nums[i], i);
            }
            diff = target - nums[j];
            if (map.containsKey(diff)) {
                return new int[]{j, map.get(diff)};
            } else {
                map.put(nums[j], j);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LeetCode1 solution = new LeetCode1();
        int[] nums = new int[]{3,1,2,1,4};

        int[] result = solution.twoSumV3(nums, 6);
        System.out.println(JSON.toJSONString(result));
    }
}
