/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
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

class Solution {
    public Node copyRandomList(Node head) {
        Node p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        Node[] node = new Node[count];
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.random = node[head.random];
        }
        return node[0];
    }
}
// @lc code=end

