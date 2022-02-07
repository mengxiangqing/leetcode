/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        //添加一个哑节点（dummy node）指针指向链表的头节点。就不需要对头节点进行特殊的判断了。
        ListNode first = head;
        ListNode second = dummy;
        int d = 0;
        ListNode temp = new ListNode();
        ListNode olio = head;
        while (olio.next != null) {
            
        }
        

    }
}
// @lc code=end

