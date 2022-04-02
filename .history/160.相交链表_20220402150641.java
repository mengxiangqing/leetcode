import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode> hash = new HashMap<>();
        ListNode p = headA;
        while (p != null) {
            hash.put(p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            if (hash.getOrDefault(p, null) != null) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
// @lc code=end
