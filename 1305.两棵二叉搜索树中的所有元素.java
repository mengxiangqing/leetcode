import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
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

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        orderTrav(root1);
        orderTrav(root2);
        Collections.sort(res);
        return res;
    }

    public void orderTrav(TreeNode root) {
        if(root == null)
            return;
        if (root.left != null) {
            orderTrav(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            orderTrav(root.right);
        }
    }
}
// @lc code=end
