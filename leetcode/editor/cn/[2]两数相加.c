//<p>给你两个&nbsp;<strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>
//
//<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>
//
//<p>你可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" /> 
//<pre>
//<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
//<strong>输出：</strong>[7,0,8]
//<strong>解释：</strong>342 + 465 = 807.
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [0], l2 = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//<strong>输出：</strong>[8,9,9,9,0,0,0,1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li> 
// <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
// <li>题目数据保证列表表示的数字不含前导零</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 8748</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 */
//struct ListNode {
//    int val;
//    struct ListNode *next;
//};


struct ListNode *addTwoNumbers(struct ListNode *l1, struct ListNode *l2) {
    struct ListNode *res =(struct ListNode *)malloc(sizeof(struct ListNode));;
    struct ListNode *p = res;
    int flag = 0;
    while (l1 != NULL || l2 != NULL || flag != 0) {
        int n1 = l1 ? l1->val : 0;
        int n2 = l2 ? l2->val : 0;
        int num = n1 + n2 + flag;
        if (num > 9) {
            flag = 1;
            num = num % 10;
        } else {
            flag = 0;
        }
        struct ListNode *temp = (struct ListNode *)malloc(sizeof(struct ListNode));
        temp->val = num;
        p->next = temp;
        p = p->next;

        if (l1 != NULL) {
            l1 = l1->next;
        }
        if (l2 != NULL) {
            l2 = l2->next;
        }

    }
    p->next = NULL;
    return res->next;
}
//leetcode submit region end(Prohibit modification and deletion)
