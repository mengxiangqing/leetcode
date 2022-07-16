import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

/*
// Definition for a Node.
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

// @lc code=start
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> que = new ArrayDeque<>();
        if (root == null)
            return res;
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = que.removeFirst();
                temp.add(node.val);
                if (node.children != null) {
                    for (int j = 0; j < node.children.size(); j++) {
                        que.add(node.children.get(j));

                    }

                }
            }
            res.add(temp);

        }

        return res;
    }
}
// @lc code=end
