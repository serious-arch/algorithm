package com.seriousarch.leetcode.linklist;

/**
 * 移除链表元素
 * See {@linktourl https://leetcode.cn/problems/remove-linked-list-elements/}
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;

        while (head != null) {
            if (head.val == val) {
                previous.next = head.next;
            } else {
                previous = head;
            }

            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode203 solution = new LeetCode203();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3))));
        ListNode result = solution.removeElements(l1, 6);
        System.out.println(result);
    }
}
