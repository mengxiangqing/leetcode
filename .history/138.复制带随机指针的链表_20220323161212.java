import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

/*
// Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// @lc code=start
class Solution {
    HashMap<Node, Node> hashMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (!hashMap.containsKey(head)) {
            Node newNode = new Node(head.val);
            hashMap.put(head, newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);

        }
        return hashMap.get(head);

    }
}
// @lc code=end

