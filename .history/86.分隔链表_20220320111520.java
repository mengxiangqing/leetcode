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
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode dummy = new ListNode();
        ListNode slow = dummy;
        ListNode newDummy = new ListNode(0,head);
        ListNode quick = newDummy;
        while (quick.next != null) {
            if (quick.next.val < x) {

                //将结点移到前面
                slow.next = quick.next;
                slow = slow.next;
                // 指针继续走
                quick.next = quick.next.next;
                slow.next = null;
            } else {
                quick = quick.next;
            }

        }
        slow.next = newDummy.next;

        return dummy.next;
    }
}
// @lc code=end
