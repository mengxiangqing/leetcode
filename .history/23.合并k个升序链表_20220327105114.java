import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>();
        return dummy.next;
    }

    /**
     * 合并两个有序列表
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a != null ? a : b;
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
                p = p.next;
            } else {
                p.next = b;
                b = b.next;
                p = p.next;
            }

        }
        p.next = a == null ? b : a;
        return dummy.next;
    }

}

// @lc code=end