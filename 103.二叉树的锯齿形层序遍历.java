import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        que.addFirst(root);
        boolean isLeft = true;
        while(!que.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            Deque<TreeNode> tempQue = new ArrayDeque<>();
            while (!que.isEmpty()) {

                if (isLeft) {
                    TreeNode node = que.removeFirst();
                    temp.add(node.val);
                    if (node.left != null)
                        tempQue.addLast(node.left);
                    if (node.right != null)
                        tempQue.addLast(node.right);
                } else {
                    TreeNode node = que.removeLast();
                    temp.add(node.val);
                    if (node.right != null)
                        tempQue.addFirst(node.right);
                    if (node.left != null)
                        tempQue.addFirst(node.left);
                }

            }

            que.addAll(tempQue);
            isLeft = !isLeft;
            res.add(temp);

        }
        return res;

    }
}
// @lc code=end
