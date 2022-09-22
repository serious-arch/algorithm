package com.seriousarch.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序
 * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序
 *
 * See {@linktourl https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/}
 */
public class LeetCodeOffer7 {

    // 标记中序遍历, key 是值，val是数组下标
    Map<Integer, Integer> map = new HashMap<>();
    // 保留的前序遍历，方便递归时依据索引查看前序遍历的值
    int[] preOrder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        // 将中序遍历的值及索引放在map中，方便递归时获取左子树与右子树的数量及其根的索引
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // 三个索引分别为
        // 当前根的索引
        // 递归树的左边界，即数组左边界
        // 递归树的右边界，即数组右边界
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }

        // 建立根节点，取自前序遍历
        int rootVal = preOrder[preRoot];
        TreeNode root = new TreeNode(rootVal);
        // 划分根节点、左子树、右子树: 拿到根节点在中序遍历中的位置
        int rootIndex = map.get(rootVal);

        // 开启左子树递归
        // 左子树的根的索引为前序中的根节点+1
        // 递归左子树的左边界为原来的中序inLeft
        // 递归左子树的右边界为中序中的根节点索引-1
        root.left = recur(preRoot + 1, inLeft, rootIndex - 1);

        // 开启右子树递归
        // 递归右子树的左边界为中序中当前根节点 + 1
        // 递归左子树的右边界为中序中原来右子树的边界
        root.right = recur(preRoot + (rootIndex - inLeft) + 1, rootIndex + 1, inRight);

        // 回溯返回根节点
        return root;
    }

    public static void main(String[] args) {
        LeetCodeOffer7 solution = new LeetCodeOffer7();
        // 前序遍历集
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        // 中序遍历集
        //
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode result = solution.buildTree(preOrder, inOrder);
        System.out.println("");
    }
}
