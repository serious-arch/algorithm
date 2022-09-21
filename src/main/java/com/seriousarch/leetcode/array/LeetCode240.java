package com.seriousarch.leetcode.array;

/**
 * 二维数组中查找目标值
 * See {@linktourl https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/}
 * See {@linktourl https://leetcode.cn/problems/search-a-2d-matrix-ii/}
 */
public class LeetCode240 {
    /**
     * Z 字形查找(双指针法)
     *
     * 时间复杂度: O(rows+columns) 在搜索的过程中，如果我们没有找到 target，那么我们要么将 curCol 减少 1，
     * 要么将 curRow 增加 1。
     * 由于 (curRow, curCol) 的初始值分别为 (0, columns)，因此 curCol 最多能被减少 columns 次，curRow 最多能被增加 rows 次，
     * 总搜索次数为 rows + columns。在这之后，curRow 和 curCol 就会超出矩阵的边界。
     * 空间复杂度: O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int columns = matrix[0].length;

        // 从右上角开始, 向左下角遍历
        int curRow = 0, curCol = columns - 1;
        while (curRow < rows && curCol >= 0) {
            int value = matrix[curRow][curCol];
            if (value == target) {
                return true;
            } else if (value < target) {
                // 如果当前格子的值小于目标值，说明目标值在矩阵下一行 (下一行更大)
                curRow++;
            } else {
                // 如果当前格子的值大于目标值，说明目标值在矩阵左侧 (左侧更小)
                curCol--;
            }
        }
        return false;
    }

    /**
     * 二维数组中查找目标值
     * 二分法
     * 时间复杂度: O(nlogm) 对一行使用二分查找的时间复杂度为 O(\log m)O(logm)，最多需要进行 nn 次二分查找。
     * 空间复杂度: O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            boolean found = binarySearch(row, target);
            if (found) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == array[middle]) {
                return true;
            } else if (target > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    /**
     * 暴力解法
     * 时间复杂度: O(mn)
     * 空间复杂度: O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }

        return false;
    }

//    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
//        int target = 18;
//
//        LeetCode240 search = new LeetCode240();
//        System.out.println(search.searchMatrix(matrix, target));
//    }
}
