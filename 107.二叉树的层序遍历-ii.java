import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 */

// @lc code=start
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

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 用于遍历树
        Deque<TreeNode> que = new ArrayDeque<>();
        // 存下来遍历过程中，每层的个数
        Deque<Integer> stack = new ArrayDeque<>();
        // 将所有的结点值存下来
        Deque<Integer> queNum = new ArrayDeque<>();
        que.add(root);
        // 层序遍历
        while (!que.isEmpty()) {
            int size = que.size();
            stack.addFirst(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = que.removeFirst();
                queNum.addLast(node.val);
                if (node.left != null)
                    que.addLast(node.left);
                if (node.right != null)
                    que.addLast(node.right);
            }
        }
        // 填写结果
        while (!stack.isEmpty()) {
            int size = stack.removeFirst();
            Integer[] curNum = new Integer[size];
            for (int i = size - 1; i >= 0; i--) {
                curNum[i] = queNum.removeLast();
            }

            res.add(Arrays.asList(curNum));
        }

        return res;
    }
}
// @lc code=end
