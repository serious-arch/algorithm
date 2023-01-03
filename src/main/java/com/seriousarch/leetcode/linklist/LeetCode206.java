package com.seriousarch.leetcode.linklist;

/**
 * 移除链表元素
 * See {@linktourl https://leetcode.cn/problems/reverse-linked-list/}
 */
public class LeetCode206 {

    /**
     * 双指针法，通过交替两两替换，得到翻转结果
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode tmp = null;

        while (current != null) {
            // 保存 current 的下一个节点，因为接下来要改变current.next
            tmp = current.next;
            // 翻转
            current.next = pre;
            // 更新 pre 和 current 指针
            pre = current;
            current = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        LeetCode206 solution = new LeetCode206();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = solution.reverseList(l1);
        System.out.println(result);
    }
}
