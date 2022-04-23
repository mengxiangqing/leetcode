import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            ListNode p = head.next;
            while (p != null && p.val <= head.val)
                p = p.next;
            if (p == null) {
                list.add(0);
            } else {
                list.add(p.val);
            }

            head = head.next;

        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
