import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        // 链表转数组
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Deque<Integer> que = new ArrayDeque<>();
        que.addFirst(list.get(0));
        int[] res = new int[list.size()];
        for (int i = 1; i < res.length; i++) {
            if (list.get(i) <= que.getFirst())
                que.addFirst(list.get(i));
            else {

                while (list.get(i) > que.getFirst()) {
                    res[i] = list.get(i);
                }

            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
