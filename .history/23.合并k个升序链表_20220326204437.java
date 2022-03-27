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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {

            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }

        });
        for (ListNode list : lists) {
            while (list != null) {
                pq.offer(list);
                list = list.next;
            }
        }
        ListNode q = dummy;
        for (ListNode node : pq) {
            q.next = node;
            q = q.next;
        }
        return dummy.next;
    }
}
// @lc code=end
