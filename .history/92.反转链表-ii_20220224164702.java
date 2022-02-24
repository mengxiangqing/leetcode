/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        // 哑巴结点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // left节点的前一个
        ListNode pre_start = new ListNode();
        pre_start = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre_start = pre_start.next;
        }
        ListNode start = pre_start.next;
        ListNode cur = start;
        ListNode pre = start.next;
        while (left++ <= right) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        pre_start.next = cur;
        start.next = pre;

        return head;
    }
}
// @lc code=end
