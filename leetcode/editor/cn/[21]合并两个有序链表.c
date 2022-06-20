//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2475 👎 0


/**
 * Definition for singly-linked list.
 */
#include<stdio.h>
#include<malloc.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

//leetcode submit region begin(Prohibit modification and deletion)

struct ListNode *mergeTwoLists(struct ListNode *list1, struct ListNode *list2) {
    if (!list1)return list2;
    if (!list2)return list1;
    struct ListNode *head = (struct ListNode *) malloc(sizeof(
                                                               struct ListNode));
    struct ListNode *p1 = list1;
    struct ListNode *p2 = list2;
    struct ListNode *s = head;
    while (p1 && p2) {
        if (p1->val <= p2->val) {
            s->next = p1;
            s = p1;
            p1 = p1->next;
        } else {
            s->next = p2;
            s = p2;
            p2 = p2->next;
        }
    }
    if (p1) {
        s->next = p1;
    }
    if (p2) {
        s->next = p2;
    }
    return head->next;

}
//leetcode submit region end(Prohibit modification and deletion)
