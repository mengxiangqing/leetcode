import java.util.List;

/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
    List<Integer> inorderList;

    public TreeNode balanceBST(TreeNode root) {
        inorderList = new ArrayList<>();
        // 中序遍历获取有序列表
        inorder(root);

        return buildBalanceTree(0, inorderList.size() - 1);
    }

    /**
     * 递归法在有序数组上生成平衡二叉搜索树
     *
     * @param l 左边界
     * @param r 右边界
     * @return
     */
    private TreeNode buildBalanceTree(int l, int r) {
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(inorderList.get(mid));
        if (mid - 1 >= l) {
            node.left = buildBalanceTree(l, mid - 1);
        }
        if (mid + 1 <= r) {
            node.right = buildBalanceTree(mid + 1, r);

        }
        return node;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}
// @lc code=end
