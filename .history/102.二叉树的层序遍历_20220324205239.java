import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            List<TreeNode> temps = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode p = queue.removeLast();


                if (p.left != null) {
                    temps.add(p.left);

                }
                if (p.right != null) {
                    temps.add(p.right);

                }
            }
            for (TreeNode temp : temps) {
                path.add(temp.val);
                queue.add(temp);

            }
            res.add(path);


        }
        return res;

    }
}
// @lc code=end
