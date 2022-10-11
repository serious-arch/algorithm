package com.seriousarch.leetcode.linklist;

/**
 * 两两交换链表中的节点
 * See {@linktourl https://leetcode.cn/problems/swap-nodes-in-pairs/}
 */
public class LeetCode24 {

    /**
     * 迭代法
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode currentNode = dummy;
        while (currentNode.next != null && currentNode.next.next != null) {
            ListNode next = currentNode.next;
            ListNode next2 = currentNode.next.next;
            currentNode.next = next2;
            next.next = next2.next;
            next2.next = next;

            currentNode = currentNode.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode24 solution = new LeetCode24();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = solution.swapPairs(l1);
        System.out.println(result);
    }
}
