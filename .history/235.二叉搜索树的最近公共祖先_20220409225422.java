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
    public TreeNode lowestCommonAncestorTwo(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();
        getPath(root, listQ, q);
        getPath(root, listP, p);
        TreeNode ans = null;
        for (int i = 0; i < listP.size() && i < listQ.size(); i++) {
            if (listP.get(i) == listQ.get(i)) {
                // 一直将相同的结点赋给ans
                ans = listP.get(i);

            } else
                // 第一个不相同的就停止
                break;
        }
        return ans;

    }

    public static void getPath(TreeNode root, List<TreeNode> path, TreeNode target) {
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else
                node = node.right;
        }
        path.add(node);
    }

    // 一次遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode node = root;
        while (node != null) {
            //p q 都比父节点值小，pq在其左孩子
            if (node.val > p.val && node.val > q.val) {
                node = node.left;

            }
            //p q 都比父节点值大，pq在其右孩子
            else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else
            // 一个大一个小就分叉啦，所以是最近共同祖先
                break;
        }
        return node;

    }

}
// @lc code=end
