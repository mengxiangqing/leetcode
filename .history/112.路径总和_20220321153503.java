/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

//  * Definition for a binary tree node.
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

// @lc code=start
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        backTrack(root, targetSum);
        return true;

    }

    private void backTrack(TreeNode root, int targetSum) {

    }
}
// @lc code=end
