import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// @lc code=start
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        int i = listP.size() - 1;
        int j = listQ.size() - 1;
        while (listP.get(i) != listQ.get(j)) {
            i--;
            j--;
        }
        return listP.get(i);

    }

    public static void getPath(TreeNode root, List<TreeNode> path, TreeNode target) {
        TreeNode node = root;
        while (node != target) {

        }
    }

}
// @lc code=end
