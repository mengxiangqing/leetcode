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
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(1, root, res);
        return res;
    }

    private void dfs(int index, TreeNode root, List<List<Integer>> res) {
        if (res.size() < index)// 妙呀
            res.add(new ArrayList<>());
        res.get(index - 1).add(root.val);
        if (root.left != null)
            dfs(index + 1, root.left, res);
        if (root.right != null)
            dfs(index + 1, root.right, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.removeFirst();
                tempList.add(node.val);
                if (node.left != null)
                    que.addLast(node.left);
                if (node.right != null)
                    que.addLast(node.right);
            }
            res.add(tempList);
        }
        return res;
    }

}
// @lc code=end
