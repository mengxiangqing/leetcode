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
        Node dummy = new Node(-1);
        Node p = head;
        Node q = dummy;
        while (p != null) {
            Node tempNode = new Node(p.val);
            hashMap.put(p, tempNode);

            q.next = tempNode;
            p = p.next;
            q = q.next;
        }

        return dummy.next;

    }
}
// @lc code=end

