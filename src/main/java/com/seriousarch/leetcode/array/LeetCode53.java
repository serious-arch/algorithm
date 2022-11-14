package com.seriousarch.leetcode.array;

/**
 * 最大连续子数组和
 * See {@linktourl https://leetcode.cn/problems/maximum-subarray/}
 */
public class LeetCode53 {

    /**
     * 暴力解法
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp + nums[j];
                result = Math.max(tmp, result);
            }
        }
        return result;
    }

    /**
     * 动态规划
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public int maxSubArrayV3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 分治法
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(logN)
     * @param nums
     * @return
     */
    public int maxSubArrayV4(int[] nums) {
        return getMax(nums, 0, nums.length - 1);
    }

    private int getMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int middle = (left + right) / 2;
        int leftSum = getMax(nums, left, middle);
        int rightSum = getMax(nums, middle+1, right);
        int crossSum = crossSum(nums, left, right);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int crossSum(int[] nums, int left, int right) {
        int middle = (left + right) / 2;
        int leftSum = nums[middle];
        int leftMax = leftSum;
        for (int i = middle - 1; i >= left; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        // from middle+1 to rightMost
        int rightSum = nums[middle+1];
        int rightMax = rightSum;
        for (int i = middle + 2; i <= right; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        LeetCode53 solution = new LeetCode53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArrayV3(nums);
        System.out.println(result);
    }
}
