package com.seriousarch.leetcode.array;

/**
 * 搜索插入位置
 * See {@linktourl https://leetcode.cn/problems/search-insert-position/}
 */
public class LeetCode35 {

    /**
     * 迭代法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分法
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        // 如果一直找不到，应该返回left
        return left;
    }

    public static void main(String[] args) {
        LeetCode35 solution = new LeetCode35();
        int[] nums = {1, 3, 5, 6};
        int val = 7;
        int result = solution.searchInsertV2(nums, val);
        System.out.println(result);
    }
}
