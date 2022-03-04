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

class Solutio {

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
        int n = 0;
        ListNode p = new ListNode();
        p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        if (n == 1 || n % k == 0)
            return head;
        k = k > n ? k % n : k;
        p = head;
        for (int i = 1; i < n - k; i++) {
            p = p.next;
        }
        ListNode newHead = new ListNode();
        newHead = p.next;
        dummy.next = newHead;
        p.next = null;
        p = dummy.next;
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        p.next = head;
        return dummy.next;
    }
}
// @lc code=end
