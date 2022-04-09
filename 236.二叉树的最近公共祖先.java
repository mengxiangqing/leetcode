import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        backTrack(listP, root, p);
        backTrack(listQ, root, q);
        TreeNode ans = null;
        for (int j = 0; j < listP.size()&& j<listQ.size(); j++) {
            if (listP.get(j) == listQ.get(j))
                ans = listP.get(j);
            else
                break;
        }
        return ans;

    }

    private void backTrack(List<TreeNode> listP, TreeNode root, TreeNode p) {
        if (root == null)
            return;
        listP.add(root);
        if (root == p)
            return;
        backTrack(listP, root.left, p);
        backTrack(listP, root.right, p);
        listP.remove(listP.size() - 1);
    }
}
// @lc code=end
