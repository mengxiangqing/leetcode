/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

/**
 * Definition for singly-linked list.
 */
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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode ph = head;
        while (ph != null && ph.next != null) {
            ListNode p = ph.next;
            if (p.val == ph.val) {
                ph.next = p.next == null ? null : p.next;
            } else
                ph = ph.next;
        }

        return head;
    }
}
// @lc code=end
