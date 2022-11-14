package com.seriousarch.leetcode.array;

import com.seriousarch.leetcode.linklist.ListNode;

/**
 * 移除元素
 * See {@linktourl https://leetcode.cn/problems/remove-element/}
 */
public class LeetCode27 {

    /**
     * 双指针法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (left < right && nums[left] != val) {
                left++;
                continue;
            }
            if (left < right && nums[right] == val) {
                right--;
                continue;
            }

            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;

        }

        if (left == right && nums[left] == val) {
            return left;
        } else {
            return left + 1;
        }
    }


    public int removeElementV2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] != val ) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }

            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        if (left == right && nums[left] == val) {
            return left;
        } else {
            return left + 1;
        }
    }


    public static void main(String[] args) {
        LeetCode27 solution = new LeetCode27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = solution.removeElementV2(nums, val);
        System.out.println(result);
    }
}
