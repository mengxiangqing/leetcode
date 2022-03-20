/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// Definition for singly-linked list.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// @lc code=start
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head.next == null)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode quick = dummy.next;
        while (quick.next != null && quick.next.next !=null) {
            if (quick.next.val<x) {
                slow.next = quick.next;
                quick.next = quick.next.next;
            }
            quick = quick.next;

        }

        return dummy.next;
    }
}
// @lc code=end
