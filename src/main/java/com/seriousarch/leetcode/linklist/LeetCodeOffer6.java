package com.seriousarch.leetcode.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * See {@linktourl https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/}
 */
public class LeetCodeOffer6 {

    /**
     * 辅助栈法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int length = stack.size();
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 时间复杂度 O(N)O(N)： 遍历链表，递归 NN 次。
     * 空间复杂度 O(N)O(N)： 系统递归需要使用 O(N)O(N) 的栈空间。
     *
     * @param head
     * @return
     */
    public int[] reversePrintV2(ListNode head) {
        if (head != null) {
            reversePrintV2(head.next);
            res.add(head.val);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

//    public static void main(String[] args) {
//        LeetCode6 solution = new LeetCode6();
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
//        int[] arr = solution.reversePrint(listNode);
//        System.out.println(arr);
//    }
}
