package com.seriousarch.leetcode.array;

import java.util.*;

/**
 * 字母异位词分组
 * See {@linktourl https://leetcode.cn/problems/group-anagrams/}
 */
public class LeetCode49 {

    /**
     * 字符计数的方法
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            int[] countTable = new int[26];
            for (char c: s.toCharArray()) {
                countTable[c - 'a']++;
            }

            // 数组不能hash，转换一下
            StringBuilder sb = new StringBuilder();
            for (int count : countTable) {
                sb.append("#");
                sb.append(count);
            }

            String key = sb.toString();
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

    /**
     * 对字符串字符排序的方法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        LeetCode49 solution = new LeetCode49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams2(strs);
        System.out.println(result);
    }
}
