package com.seriousarch.leetcode.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 两数相加
 * See {@linktourl https://leetcode.cn/problems/add-two-numbers/}
 */
public class LeetCode2 {

    /**
     * 迭代法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            // 通过取模，拿到个位上的数
            current.next = new ListNode(sum % 10);
            current = current.next;

            // 取进位
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return dummy.next;
    }

    /**
     * 递归法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        int total = l1.val + l2.val;
        int carry = total / 10;
        ListNode result = new ListNode(total % 10);
        if (l1.next != null || l2.next != null || carry != 0) {
            l1 = l1.next != null ? l1.next : new ListNode(0);
            l2 = l2.next != null ? l2.next : new ListNode(0);
            l1.val += carry;
            result.next = addTwoNumbers(l1, l2);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode2 solution = new LeetCode2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}
