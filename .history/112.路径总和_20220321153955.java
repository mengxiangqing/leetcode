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

        backTrack(root, targetSum,0);
        return true;

    }

    private boolean backTrack(TreeNode root, int targetSum,int curSum) {
        if (curSum == targetSum && root.left == null && root.right == null) {
            return true;
        }
        //左孩子
        if (root.left != null) {
            return backTrack(root.left, targetSum, curSum + root.val);
        }
        // 右孩子
        if (root.right != null) {
            return backTrack(root.right, targetSum, curSum+root.val);
        }
    }
}
// @lc code=end
