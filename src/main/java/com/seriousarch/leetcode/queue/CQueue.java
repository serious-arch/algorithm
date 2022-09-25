package com.seriousarch.leetcode.queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * See {@linktourl https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/}
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
            }
        }

        if (stack2.isEmpty()) {
            return -1;
        }

        return stack2.pop();
    }

}
