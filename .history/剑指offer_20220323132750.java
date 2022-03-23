import java.util.*;

public class 剑指offer {
    public static void main(String[] args) {

    }
}
class ListNode {
     int val;
     ListNode next;

     ListNode(int x) {
         val = x;
     }
 }
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.addFirst(head.val);
            head = head.next;
        }
        int[] num = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            num[i++] = stack.removeFirst();
        }
        return num;
    }
}

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) //这个条件就不用特意判断head是不是空了
         {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }

        return cur;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class CopyComplixList {

    public Node copyRandomList(Node head) {

    }
}