/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {

  // public TreeNode invertTree(TreeNode root) {
  // if (root == null)
  // return null;
  // TreeNode left = invertTree(root.left);
  // TreeNode right = invertTree(root.right);
  // root.left = right;
  // root.right = left;
  // return root;

  // }

  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;
  }
}
// @lc code=end
