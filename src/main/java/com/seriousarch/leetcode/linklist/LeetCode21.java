package com.seriousarch.leetcode.linklist;

/**
 * 合并两个有序链表
 * See {@linktourl https://leetcode.cn/problems/merge-two-sorted-lists/}
 */
public class LeetCode21 {

    /**
     * 迭代法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode21 solution = new LeetCode21();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(l1, l2);
        System.out.println(result);
    }
}
