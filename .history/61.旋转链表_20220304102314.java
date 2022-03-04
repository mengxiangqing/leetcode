/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * 61.旋转链表
 */
// class ListNode {
// int val;
// ListNode next;

// ListNode() {
// }

// ListNode(int val) {
// this.val = val;
// }

// ListNode(int val, ListNode next) {
// this.val = val;
// this.next = next;
// }
// }

class Solution {

    public ListNode creaListNode(int[] nums) {
        ListNode dummy = new ListNode();
        // 头插法
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(nums[i]);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        return dummy.next;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0)
            return head;
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        int n = 1;
        ListNode p = new ListNode();
        p = head;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        k = k >= n ? k % n : k;
        if (n == 1 || k==0)
            return head;
        //闭合为环
        p.next = head;
        for (int i = 0; i < n - k ; i++) {
            p = p.next;
        }
        ListNode op = new ListNode();
        op = p.next;
        dummy.next = op;
        p.next = null;
        return dummy.next;
    }
}
// @lc code=end
