/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start

// class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }

class Solution {
    public  ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head;
        ListNode pre_start = new ListNode();
        ListNode end = new ListNode();
        while (p != null) {
            if (p.next.val == p.next.next.val) {
                int val = p.next.val;
                pre_start = p;
                p = p.next;
                while (p.val == val) {
                    p = p.next;
                }
                pre_start.next = p;
            }
            p = p.next;
        }
        return dummy.next;
    }

}
// @lc code=end
