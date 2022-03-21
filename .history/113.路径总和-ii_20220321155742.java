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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        backTrack(res, path, root, targetSum, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> path, TreeNode root, int targetSum, int curSum) {
        curSum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && curSum == targetSum) {
            res.add(new ArrayList<>(path));
        } else {
            if (root.left != null) {
                backTrack(res, path, root.left, targetSum, curSum);
            }
            if (root.right != null) {
                backTrack(res, path, root.right, targetSum, curSum);
            }
        }
        path.remove(path.size() - 1);

    }
}
// @lc code=end
