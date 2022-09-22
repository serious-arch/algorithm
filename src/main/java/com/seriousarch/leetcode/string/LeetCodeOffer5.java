package com.seriousarch.leetcode.string;

/**
 * 替换空格
 * See {@linktourl https://leetcode.cn/problems/ti-huan-kong-ge-lcof/}
 */
public class LeetCodeOffer5 {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else  {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
