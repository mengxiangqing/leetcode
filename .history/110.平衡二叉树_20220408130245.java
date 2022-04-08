/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return Math.abs(depthLeft - depthRight) <= 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int depth = Integer.MIN_VALUE;
        if (root.left!=null) {
            depth = Math.max(maxDepth(root.left), depth);

        }
        if (root.right != null) {
            depth = Math.max(maxDepth(root.right), depth);

        }
        return depth + 1;
    }
}
// @lc code=end
