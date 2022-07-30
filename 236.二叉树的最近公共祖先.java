import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // key 是节点，value是父亲
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        // 层序遍历，建立父子关系
        Deque<TreeNode> que = new ArrayDeque<>();
        parentMap.put(root, null);
        que.addLast(root);
        while (!que.isEmpty()) {
            int curSize = que.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = que.removeLast();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    que.addLast(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    que.addLast(node.right);
                }
            }
        }

        Set<TreeNode> temp = new HashSet<>();
        // 将p的族谱收集下来
        while (p != null) {
            temp.add(p);
            p = parentMap.get(p);
        }
        while (q != null) {

            if (temp.add(q) == false) {
                return q;
            }
            q = parentMap.get(q);

        }
        return root;
    }

}
// @lc code=end
