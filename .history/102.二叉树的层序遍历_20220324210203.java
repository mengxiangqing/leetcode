import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
        // res.add(Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
        //     List<TreeNode> temps = new ArrayList<>();
        //     //将某层的结点都取出队列，并将子孩子存起来
        //     while (!queue.isEmpty()) {
        //         TreeNode p = queue.removeLast();

        //         if (p.left != null) {
        //             temps.add(p.left);

        //         }
        //         if (p.right != null) {
        //             temps.add(p.right);

        //         }
        //     }
        //     // 将子孩子结点放入队列
        //     for (TreeNode temp : temps) {
        //         path.add(temp.val);
        //         queue.addFirst(temp);

        //     }
        //     if (!path.isEmpty())
        //         res.add(path);

        // }
        int size = queue.size();//size就是当前层的个数
        for (int i = 0; i < size; i++) {
            TreeNode p = queue.removeLast();
            path.add(p.val);
            if(p.left!=null)queue.addFirst(p.left);
            if(p.right!=null)queue.addFirst(p.right);
        }
        return res;

    }
}
// @lc code=end
