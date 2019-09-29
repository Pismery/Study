package com.pismery.study.algorithm.leetcode;

/**
 * 104. 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {

    public int solution1(TreeNode root) {
        return deep(root, 0);
    }

    public int deep(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int left = depth + 1;
        int right = depth + 1;
        if (node.left != null)
            left = deep(node.left, depth + 1);
        if (node.right != null) {
            right = deep(node.right, depth + 1);
        }
        return Math.max(left, right);


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}