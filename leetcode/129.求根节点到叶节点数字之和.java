import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 */
class Solution {

    private int count;

    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        count = 0;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(path, root);
        return count;
    }

    public void dfs(List<Integer> path, TreeNode root) {
        if (root.left == null && root.right == null) {

            // 到底了
            int temp = 0;
            for (int i : path) {
                temp = temp * 10 + i;
            }
            count += temp;
        }

        if (root.left != null) {
            path.add(root.left.val);
            dfs(path, root.left);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            dfs(path, root.right);
            path.remove(path.size() - 1);
        }

    }
}
// @lc code=end
