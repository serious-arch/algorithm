package com.seriousarch.leetcode.linklist;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * See {@linktourl https://leetcode.cn/problems/linked-list-cycle/description/}
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        Set<Integer> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head.val)) {
                return true;
            }

            seen.add(head.val);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode141 solution = new LeetCode141();
        ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next;
        System.out.println(solution.hasCycle(head));
    }
}
