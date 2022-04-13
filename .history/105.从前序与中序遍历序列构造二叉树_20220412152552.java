import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode s = new TreeNode();
        int i = 0;
        if (preorder.length <= 0)
            return null;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }
        s.val = preorder[0];
        s.left = buildTree(Arrays.copyOfRange(preorder, 1,preorder.length), Arrays.copyOfRange(inorder, 0, i-1));
        s.right = buildTree(Arrays.copyOfRange(preorder, 1,preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));

    }
}
// @lc code=end
