import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        res.add(root.val);
        if (root.left != null)
            res.addAll(preorderTraversal(root.left));
        if (root.right != null)
            res.addAll(preorderTraversal(root.right));
    }
}
// @lc code=end
