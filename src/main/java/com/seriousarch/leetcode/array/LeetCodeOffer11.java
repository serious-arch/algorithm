package com.seriousarch.leetcode.array;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * See {@linktourl https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/}
 */
public class LeetCodeOffer11 {
    public int minArray(int[] numbers) {
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length; j++) {
                min = Math.min(numbers[i], numbers[j]);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        LeetCodeOffer11 solution = new LeetCodeOffer11();
        int[] numbers = new int[]{3, 4, 5, 1, 2};
        System.out.println(solution.minArray(numbers));
    }
}
