package com.seriousarch.leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int[] array = Arrays.copyOf(sourceArray, length);

        for (int i = 1; i < length; i++) {
            // 标记位，若为true，则表示此循环没有交换，即数组已有序，冒泡结束
            boolean flag = true;
            for (int j = 0; j < length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return array;
    }

    public int[] sort2(int[] sourceArray) {
        int length = sourceArray.length;
        int[] array = Arrays.copyOf(sourceArray, length);
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < length - 1; i++) {
                int current = array[i];
                int next = array[i + 1];

                if (current > next) {
                    int tmp = array[i];
                    array[i] = next;
                    array[i + 1] = tmp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] result = bubbleSort.sort(new int[]{5, 3, 2, 7, 8});
        System.out.println(result);
    }
}
