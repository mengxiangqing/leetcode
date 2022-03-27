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
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val -
        // v2.val);
        // for (ListNode node : lists) {
        // if (node != null)
        // pq.offer(node);

        // }
        // ListNode p = dummy;
        // while (!pq.isEmpty()) {
        // ListNode node = pq.poll();
        // p.next = node;
        // p = p.next;
        // if (node.next != null) {
        // pq.offer(node.next);

        // }
        // }
        // 两两合并
        return dummy.next;
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        else {
            int mid = (right - left) / 2 + left;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);

        }
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