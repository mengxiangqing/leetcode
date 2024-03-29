import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

/*
// Definition for a Node.
*/
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

// @lc code=start
class Solution {
    HashMap<Node, Node> hashMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node p = head;
        Node q = dummy;
        while (p != null) {
            // 创建新结点
            Node newNode = new Node(p.val);
            //保存新老链表结点映射关系
            hashMap.put(p, newNode);

            q.next = newNode;
            p = p.next;
            q = q.next;
        }
        // 复制random指针
        q = dummy.next;
        while (head != null) {
            if (head.random != null) {
                q.random = hashMap.get(head.random);
            }
            head = head.next;
            q = q.next;
        }
        return dummy.next;

    }
}
// @lc code=end

