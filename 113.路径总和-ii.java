import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

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

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return res;
        backTrack(root, targetSum, 0);
        return res;
    }

    private void backTrack(TreeNode root, int targetSum, int curSum) {
        curSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && curSum == targetSum) {
            res.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                backTrack(root.left, targetSum, curSum);
            }
            if (root.right != null) {
                backTrack(root.right, targetSum, curSum);
            }
        }
        path.remove(path.size() - 1);

    }
}
// @lc code=end
