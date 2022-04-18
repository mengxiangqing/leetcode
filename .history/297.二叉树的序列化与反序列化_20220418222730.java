import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addLast(root);
        int index = 0;
        while (!que.isEmpty()) {
            Deque<TreeNode> cur = new ArrayDeque<>();
            while (!que.isEmpty()) {// 先不要加入原来的队列，将这一层遍历完再一块加进去

                TreeNode node = que.removeFirst();
                TreeNode left = null;
                TreeNode right = null;
                if (++index < datas.length && !datas[index].equals(null)) {
                    left = new TreeNode(Integer.parseInt(datas[index]));
                    cur.addLast(left);
                }
                if (++index < datas.length && !datas[index].equals(null)) {
                    right = new TreeNode(Integer.parseInt(datas[index++]));
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            que = cur;
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
