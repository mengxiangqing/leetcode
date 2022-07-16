import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
        return res;

    Deque<TreeNode> que = new ArrayDeque<>();
    que.add(root);

    while (!que.isEmpty()) {
        int size = que.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            TreeNode node = que.removeFirst();
            max = Math.max(max, node.val);
            if (node.left != null)
                que.addLast(node.left);
            if (node.right != null)
                que.addLast(node.right);
        }
        res.add(max);
    }

    return res;
    }
}
// @lc code=end

