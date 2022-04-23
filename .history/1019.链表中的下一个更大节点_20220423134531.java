import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(Arrays.toString(list.toArray()));
        // 存放数值和下标的栈 【val,index】
        Deque<int[]> que = new ArrayDeque<>();
        que.addFirst(new int[] { list.get(0), 0 });
        int[] res = new int[list.size()];
        for (int i = 1; i < res.length; i++) {
            if (list.get(i) <= que.getFirst()[0])
                que.addFirst(new int[] { list.get(i), i });
            else {
                while (list.get(i) > que.getFirst()[0]) {
                    res[que.getFirst()[1]] = list.get(i);
                    que.removeFirst();
                }
                que.addFirst(new int[] { list.get(i), i });

            }
        }
        return res;
    }
}
// @lc code=end
