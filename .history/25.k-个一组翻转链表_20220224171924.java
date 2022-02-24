import java.util.List;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
      
        ListNode cur = head;
        while(cur != null){
            length ++;
            cur = cur.next;
        }
        int start = 1;
        
        ListNode res = head;
        while(start+k<=length){
            res = reverseBetween(res,start,start+k-1);
            start += k;
        }
        return res;


    }
    //翻转left-right
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 哑巴结点
        ListNode dummy = new ListNode();
        dummy.next = head;
        // left节点的前一个
        ListNode pre_start = new ListNode();
        pre_start = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre_start = pre_start.next;
        }
        ListNode start = pre_start.next;
        ListNode cur = start;
        ListNode pre = start.next;
        while (left++ < right) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        pre_start.next = cur;
        start.next=pre;

        return dummy.next;
    }
}
// @lc code=end

