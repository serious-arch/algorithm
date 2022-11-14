package com.seriousarch.leetcode.array;

import java.util.*;

/**
 * 全排列
 *
 * See {@linktourl https://leetcode.cn/problems/permutations/}
 */
public class LeetCode46 {

    /**
     * 回溯法
     * 时间复杂度：O(N*N)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            visited.put(num, false);
        }
        backtracking(nums, result, visited, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, Map<Integer, Boolean> visited, List<Integer> list) {
        if (list.size() == nums.length) {
            // 因为list会一直复用，所以这里需要new一下ArrayList，做深拷贝
            result.add(new ArrayList<>(list));
            return ;
        }

        for (int num : nums) {
            if (!visited.get(num)) {
                list.add(num);
                visited.put(num, true);
                backtracking(nums, result, visited, list);
                list.remove(list.size() - 1);
                visited.put(num, false);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode46 solution = new LeetCode46();
        int[] nums = {1,2,3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}
