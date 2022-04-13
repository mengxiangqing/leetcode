import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left,
            int in_right) {
        if (pre_left > pre_right)
            return null;
        int preorder_root = pre_left;
        int inorder_root = indexMap.get(preorder[preorder_root]);

        //建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);

        // 得到左子树结点数目
        int size_left_num = in_right - in_left;



        return root;
    }
}
// @lc code=end
