import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    /*
     * 前序遍历的结果是 根->左->右
     * 后序遍历的结果是 左->右->根
     * 1. 如果在前序遍历过程中将 节点的值 插在链表后面变为插在链表前面，则变为 右->左->根
     * 2. 如果在1的基础上将前序遍历过程中，先处理左节点后处理右子结点 修改为 先处理右子结点再处理左子节点，则变为 左->右->根
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // 双向链表
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                // 如果1，前面添加元素
                res.addFirst(root.val);
                stack.addFirst(root);
                // 如果2，先处理右子节点
                root = root.right;
            }
            root = stack.removeFirst();
            // 再处理左子节点
            root = root.left;
        }
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);

    }
}
// @lc code=end
