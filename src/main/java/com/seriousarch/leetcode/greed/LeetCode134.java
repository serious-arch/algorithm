package com.seriousarch.leetcode.greed;

/**
 * 加油站
 *
 * https://leetcode.cn/problems/gas-station/description/
 */
public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        LeetCode134 solution = new LeetCode134();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
