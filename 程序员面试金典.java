import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 程序员面试金典 {

  public static void main(String[] args) {
    Solution0804 so = new Solution0804();
    so.subsets(new int[] { 1, 2, 3 });

  }

  private static ListNode createList(int[] num) {
    ListNode dummy = new ListNode(0);
    ListNode r = dummy;
    for (int i = 0; i < num.length; i++) {
      ListNode p = new ListNode(num[i]);
      r.next = p;
      r = r.next;
    }
    r.next = null;

    return dummy.next;
  }
}

/**
 * 面试题 05.06. 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 */
class Solution0506 {
  public int convertInteger(int A, int B) {
    String AString = Integer.toBinaryString(A);
    String BString = Integer.toBinaryString(B);
    int lenA = AString.length();
    int lenB = BString.length();
    if (lenA > lenB) {
      for (int i = 0; i < lenA - lenB; i++) {
        BString = '0' + BString;
      }
    } else if (lenA < lenB) {
      for (int i = 0; i < lenB - lenA; i++) {
        AString = '0' + AString;
      }
    }
    int count = 0;
    for (int i = 0; i < AString.length(); i++) {
      if (AString.charAt(i) != BString.charAt(i)) {
        count++;
      }
    }
    return count;
  }
}

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 
 * 说明：解集不能包含重复的子集。
 */

class Solution0804 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int i = 0; i < nums.length; i++) {
      int size = res.size();
      // 遍历结果集中的每一个元素，往里添加nums[i]
      for (int j = 0; j < size; j++) {
        List<Integer> temp = new ArrayList<>(res.get(j));
        temp.add(nums[i]);
        res.add(temp);
      }

    }
    return res;
  }
}

/**
 * 面试题 05.08. 绘制直线
 * 已知一个由像素点组成的单色屏幕，每行均有 w 个像素点，所有像素点初始为 0，左上角位置为 (0,0)。
 * 
 * 现将每行的像素点按照「每 32 个像素点」为一组存放在一个 int 中，再依次存入长度为 length 的一维数组中。
 * 
 * 我们将在屏幕上绘制一条从点 (x1,y) 到点 (x2,y) 的直线（即像素点修改为 1），请返回绘制过后的数组。
 * 
 * 
 * 
 * 注意：
 * 
 * 用例保证屏幕宽度 w 可被 32 整除（即一个 int 不会分布在两行上）
 */
class Solution0508 {
  public int[] drawLine(int length, int w, int x1, int x2, int y) {
    int[] res = new int[length];
    // 求行数
    int h = length * 32 / w;
    // 每一行个数
    int num = w / 32;
    int index = 0;
    // 遍历每一行
    for (int i = 0; i < h; i++) {
      // 直线在这一行
      if (i == y) {
        index = i * num;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < w; j++) {
          if (j >= x1 && j <= x2) {
            sb.append('1');
          } else {
            sb.append('0');
          }
          if (sb.length() == 32) {
            res[index++] = Integer.parseUnsignedInt(sb.toString(), 2);
            // 清空StringBuilder
            sb.delete(0, sb.length());
          }
        }
      }
    }
    return res;
  }
}

/**
 * 面试题 05.01. 插入
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * 
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 */
class Solution0501 {
  public int insertBits(int N, int M, int i, int j) {
    String NStr = Integer.toBinaryString(N);
    String MStr = Integer.toBinaryString(M);
    int maxLen = 0;
    maxLen = Math.max(NStr.length(), maxLen);
    maxLen = Math.max(MStr.length(), maxLen);
    maxLen = Math.max(j, maxLen);
    int len = maxLen - NStr.length();
    if (NStr.length() < maxLen) {
      for (int k = 0; k < len; k++) {
        NStr = '0' + NStr;
      }
    }
    StringBuilder sb = new StringBuilder();
    int n = MStr.length() - 1;
    int m = 0;
    for (int k = NStr.length() - 1; k >= 0; m++, k--) {
      if (m >= i && m <= j) {
        if (n < 0) {
          sb.append('0');
        } else
          sb.append(MStr.charAt(n--));
      } else {
        sb.append(NStr.charAt(k));
      }
    }
    if (m <= j) {
      if (n < 0) {
        sb.append('0');
      } else
        sb.append(MStr.charAt(n--));
    }
    return Integer.parseInt(sb.reverse().toString(), 2);

  }
}

/**
 * 面试题 03.05. 栈排序
 * 栈排序。
 * 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek
 * 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 示例1:
 *
 * 输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null,null,null,1,null,2]
 * 示例2:
 *
 * 输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * 输出：
 * [null,null,null,null,null,true]
 * 说明:
 *
 * 栈中的元素数目在[0, 5000]范围内。
 */
class SortedStack {
  class ListNode {
    int val;
    ListNode pre;
    ListNode next;
  }

  ListNode head;
  ListNode end;

  public SortedStack() {
    head.next = end;
    head.val = -1;
    end.val = -1;
    end.pre = head;
  }

  public void push(int val) {
    ListNode newNode = new ListNode();
    newNode.val = val;
  }

  public void pop() {
    ListNode node = end.pre;
    node.pre.next = end;
    end.pre = node.pre;
  }

  public int peek() {
    return end.pre.val;

  }

  public boolean isEmpty() {
    return head.next == end && end.pre == head;
  }
}

/**
 * 面试题 03.04. 化栈为队
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 *
 * 示例：
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek(); // 返回 1
 * queue.pop(); // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 */
class MyQueue {
  Deque<Integer> stack1;
  Deque<Integer> stack2;

  /** Initialize your data structure here. */
  public MyQueue() {
    stack1 = new ArrayDeque<>();
    stack2 = new ArrayDeque<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    stack1.addFirst(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.addFirst(stack1.removeFirst());
      }
    }
    return stack2.removeFirst();
  }

  /** Get the front element. */
  public int peek() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.addFirst(stack1.removeFirst());
      }
    }
    return stack2.getFirst();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}

/**
 * 面试题 03.03. 堆盘子
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 *
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 *
 * 示例1:
 *
 * 输入：
 * ["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
 * [[1], [1], [2], [1], [], []]
 * 输出：
 * [null, null, null, 2, 1, -1]
 *
 */

class StackOfPlates {
  private List<Deque<Integer>> stacks;
  private int cap;

  public StackOfPlates(int cap) {
    stacks = new ArrayList<>();
    this.cap = cap;
  }

  public void push(int val) {
    if (cap <= 0) {
      return;
    }

    // 栈列表为空 或者 当前栈满了 新增栈
    if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() >= cap) {
      stacks.add(new ArrayDeque<>());
    }
    stacks.get(stacks.size() - 1).addFirst(val);
  }

  public int pop() {
    if (stacks.isEmpty()) {
      return -1;
    }
    int result = stacks.get(stacks.size() - 1).removeFirst();
    // 最上面的栈空了，就删除
    while (stacks.get(stacks.size() - 1).isEmpty()) {
      stacks.remove(stacks.size() - 1);

    }
    return result;
  }

  public int popAt(int index) {
    if (stacks.isEmpty() || index > stacks.size() - 1) {
      return -1;
    }
    int result = stacks.get(index).removeFirst();
    if (stacks.get(index).isEmpty()) {
      stacks.remove(index);
    }
    return result;

  }
}

/*
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O
 * (1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); --> 返回 -3.
 * minStack.pop();
 * minStack.top(); --> 返回 0.
 */
class MinStack {
  // 记录值
  Deque<Integer> stack;
  // 记录栈内的最小值
  Deque<Integer> min;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new ArrayDeque<>();
    min = new ArrayDeque<>();
  }

  public void push(int x) {
    stack.addFirst(x);
    if (min.isEmpty()) {
      min.addFirst(x);
    } else {
      int curMin = min.getFirst();
      min.addFirst(curMin > x ? x : curMin);
    }
  }

  public void pop() {
    stack.removeFirst();
    min.removeFirst();
  }

  public int top() {
    return stack.getFirst();
  }

  public int getMin() {
    return min.getFirst();
  }
}

/*
 * 面试题 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum,
 * value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，
 * value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * 示例1:
 *
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 */
class TripleInOne {
  int[][] num;
  int stackSize;

  public TripleInOne(int stackSize) {

    num = stackSize <= 3 ? new int[4][3] : new int[4][stackSize];
    this.stackSize = stackSize;
  }

  public void push(int stackNum, int value) {
    int index = num[3][stackNum];
    if (index < stackSize) {
      num[stackNum][index] = value;
      num[3][stackNum]++;
    }
  }

  public int pop(int stackNum) {
    if (num[3][stackNum] == 0) {
      return -1;
    }

    int result = num[stackNum][num[3][stackNum] - 1];
    num[stackNum][num[3][stackNum] - 1] = 0;
    num[3][stackNum]--;
    return result;
  }

  public int peek(int stackNum) {
    if (num[3][stackNum] == 0) {
      return -1;
    }
    return num[stackNum][num[3][stackNum] - 1];
  }

  public boolean isEmpty(int stackNum) {
    if (num[3][stackNum] == 0) {
      return true;
    } else
      return false;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {

  // 面试题 02.08. 环路检测
  // 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
  // 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos
  // 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos
  // 不作为参数进行传递，仅仅是为了标识链表的实际情况。
  public ListNode detectCycle(ListNode head) {
    ListNode p = head;
    ListNode q = head;
    while (q.next != null && q.next.next != null) {
      q = q.next.next;
      p = p.next;
      if (p == q)
        return p;
    }
    return null;
  }

  // 面试题 02.07. 链表相交
  // 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

  // 涨涨记性吧
  // 浪漫相遇题
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    ListNode p = headA;
    ListNode q = headB;
    while (p != q) {
      p = p != null ? p.next : headB;
      q = q != null ? q.next : headA;
    }
    return p;
  }

  // 翻转链表
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode pre = null;
    ListNode cur = head;
    // 1->2->3->4->5
    // p c
    while (cur != null) {
      ListNode tempNext = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tempNext;
    }
    return pre;
  }

  /**
   * 面试题 02.06. 回文链表
   * 编写一个函数，检查输入的链表是否是回文的。
   *
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {
    // ListNode p = head;
    // Deque<Integer> stack = new ArrayDeque<>();
    // while (p != null) {
    // stack.addFirst(p.val);
    // p = p.next;
    // }
    // p = head;
    // while (p != null) {
    // if (p.val != stack.removeFirst())
    // return false;
    // p = p.next;
    // }
    // return true;

    if (head == null)
      return true;
    ListNode slow = head;
    ListNode fast = head;
    // 使用快慢指针找到链表中间值
    while (fast.next != null && fast.next.next != null) {
      // 慢指针一次走一步，快指针走两步
      fast = fast.next.next;
      slow = slow.next;
    }
    // 翻转后半部分链表
    ListNode second = reverseList(slow.next);
    ListNode q = second;
    ListNode p = head;
    boolean result = true;
    while (result && q != null) {
      if (p.val != q.val) {
        result = false;
      }
      p = p.next;
      q = q.next;
    }
    // 还原链表
    slow.next = reverseList(second);
    return result;
  }

  /**
   * 面试题 02.05. 链表求和
   * 给定两个用链表表示的整数，每个节点包含一个数位。
   * 这些数位是反向存放的，也就是个位排在链表首部。
   * 编写函数对这两个整数求和，并用链表形式返回结果。
   *
   * @param l1
   * @param l2
   * @return
   */

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int flag = 0; // 进位 取0 或 1
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    while (l1 != null || l2 != null) {
      int num1 = l1 == null ? 0 : l1.val;
      int num2 = l2 == null ? 0 : l2.val;
      int count = num1 + num2 + flag;
      ListNode temp = l1 != null ? l1 : l2;
      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;
      // 有进位
      if (count > 9) {
        flag = 1;
        temp.val = count - 10;
      } else {
        flag = 0;
        temp.val = count;
      }
      p.next = temp;
      p = p.next;
    }
    if (flag != 0) {
      ListNode temp = new ListNode(1);
      p.next = temp;
      p = p.next;
    }
    p.next = null;

    return dummy.next;
  }

  /**
   * 面试题 02.04. 分割链表
   * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
   * 你不需要 保留 每个分区中各节点的初始相对位置。
   *
   * @param head
   * @param x
   * @return
   */
  public ListNode partition(ListNode head, int x) {
    // 维护两个链表，一个比x小的值，另一个放大值，然后拼接
    if (head == null)
      return head;
    ListNode p = head;
    ListNode small = new ListNode(0);
    ListNode p1 = small;
    ListNode large = new ListNode(0);
    ListNode p2 = large;
    while (p != null) {
      if (p.val < x) {
        p1.next = p;
        p1 = p1.next;
      } else {
        p2.next = p;
        p2 = p2.next;
      }
      p = p.next;
    }

    p1.next = large.next;
    p2.next = null;
    return small.next;
  }

  /**
   * 面试题 02.03. 删除中间节点
   * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
   * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
   * 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
   */
  public void deleteNode(ListNode node) {
    // NB,思想太妙了。将下个节点值复制过来，然后跳过下个节点
    node.val = node.next.val;
    node.next = node.next.next;
  }

  /**
   * 面试题 02.02. 返回倒数第 k 个节点
   * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值
   *
   * @param head
   * @param k
   * @return
   */
  public int kthToLast(ListNode head, int k) {
    int index = 0;
    ListNode p = head;

    while (p != null && index < k) {
      p = p.next;
      index++;
    }
    ListNode q = head;
    while (p != null) {
      p = p.next;
      q = q.next;
    }
    return q.val;
  }

  /**
   * 移除重复结点
   *
   * @param head
   * @return
   */
  public ListNode removeDuplicateNodes1(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode p = head;
    ListNode pre = head;
    ListNode q = head.next;
    // p指向每一个不同数字的第一位，慢慢从头往后走
    // q是遍历指针
    while (p != null) {
      pre = p;
      q = p.next;
      while (q != null) {
        while (q != null && p != null && q.val == p.val) {
          pre.next = q.next;
          q = pre.next;
        }
        if (pre != null)
          pre = pre.next;
        if (q != null)
          q = q.next;
      }
      p = p.next;
    }
    return head;
  }

  public ListNode removeDuplicateNodes(ListNode head) {
    if (head == null)
      return head;
    Set<Integer> occ = new HashSet<>();
    occ.add(head.val);
    ListNode pre = head;
    while (pre.next != null) {
      ListNode cur = pre.next;
      // 添加成功说明之前没有重复的
      if (occ.add(cur.val)) {
        pre = pre.next;
      } else
        pre.next = pre.next.next;
    }
    pre.next = null;
    return head;
  }

  /**
   * 面试题 01.09. 字符串轮转
   * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）
   *
   * @param matrix
   */
  public boolean isFlipedString(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.length() == 0 && s2.length() == 0) {
      return true;
    }
    // 拼接两个s2，如果是s2是s1旋转后，则肯定包含一个s1
    String s = s2 + s2;
    return s.contains(s1);
  }

  /**
   * 面试题 01.08. 零矩阵
   * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
   *
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int a[] = new int[m];
    int b[] = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          if (a[i] == 0) {
            a[i] = 1;
          }
          if (b[j] == 0) {
            b[j] = 1;
          }
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (a[i] == 1 || b[j] == 1)
          matrix[i][j] = 0;
      }
    }
  }

  /**
   * 面试题1.6 旋转矩阵
   *
   * @param matrix
   */
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
    }
  }

  /**
   * 判断字符是否唯一
   *
   * @param astr
   * @return
   */
  public boolean isUnique(String astr) {
    int bitMap = 0x00000001; // 除了最后一位, 其余位置用于记录特定的字母是否出现过, 当然不是所有的位置都使用上了, 因为字母只有 26 个
    for (char c : astr.toCharArray()) {
      int mask = 0x00000001;
      int offset = c - 'a' + 1; // + 1 是为了避开最后一位, 这样即使是字母 `a` 也至少会左移一位
      if (((mask << offset) & bitMap) == 0) { // 只有 1 & 1 == 1, 所以如果按位与之后的值不为 0 , 说明相同的 offset 位置上的字节在之前的循环中被按位或成了 1
        bitMap |= (mask << offset); // 将 offset 位置按位或成 1
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * 判断是否是重排字符串
   *
   * @param s1
   * @param s2
   * @return
   */
  public boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    Map<Character, Integer> sMap1 = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      sMap1.put(c1, sMap1.getOrDefault(c1, 0) + 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char c2 = s2.charAt(i);
      sMap1.put(c2, sMap1.getOrDefault(c2, 0) - 1);
      if (sMap1.get(c2) < 0)
        return false;
    }
    return true;
  }

  /**
   * URL化
   */
  public String replaceSpaces(String S, int length) {
    char arr[] = S.toCharArray();
    int right = S.length() - 1;
    int left = length - 1;

    while (left >= 0) {
      if (arr[left] == ' ') {
        arr[right--] = '0';
        arr[right--] = '2';
        arr[right--] = '%';
      } else
        arr[right--] = arr[left];

      left--;
    }
    while (right >= 0) {
      arr[right--] = ' ';
    }

    return new String(arr).trim();
  }

  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    // 偶数字符串，则不能有字符是奇数个
    if (s.length() % 2 == 0) {
      int count = 0;
      for (char c : map.keySet()) {
        if (map.get(c) % 2 == 1)
          count++;
        if (count > 0)
          return false;
      }
      return true;
    } else {
      // 只能有一个字符是奇数个
      int count = 0;
      for (char c : map.keySet()) {
        if (map.get(c) % 2 == 1)
          count++;
        if (count > 1)
          return false;
      }
      return true;
    }
  }

  /**
   * 一次编辑
   *
   * @param first
   * @param second
   * @return
   */
  public boolean oneEditAway(String first, String second) {
    // 看看长度差值
    int len1 = first.length();
    int len2 = second.length();
    // s1 是长的，s2 是短串
    String s1 = len1 > len2 ? first : second;
    String s2 = s1.equals(first) ? second : first;
    len1 = s1.length();
    len2 = s2.length();
    if (Math.abs(len1 - len2) > 1)
      return false;
    if (s1.equals("") || s2.equals(""))
      return true;
    boolean oneEdit = false; // 表示是否操作过一次
    int index1 = 0;
    int index2 = 0;
    if (len1 == len2) {
      while (index1 < len1 || index2 < len2) {
        if (s1.charAt(index1) == s2.charAt(index2)) {
          index1++;
          index2++;
        } else {
          if (oneEdit) {
            // 如果已经编辑过一次了，还需要编辑就返回false
            return false;
          } else {
            oneEdit = true;
            index1++;
            index2++;
          }
        }
      }
    } else {
      // s1是长串，s2是短串
      while (index1 < len1) {
        if (index2 == len2)
          return true;
        if (s1.charAt(index1) == s2.charAt(index2)) {
          index1++;
          index2++;
        } else {
          if (oneEdit)
            return false;
          else {
            index1++;
            oneEdit = true;
          }
        }
      }
    }

    return true;
  }

  /**
   * 面试题06 压缩字符串
   *
   * @param S
   * @return
   */
  public String compressString(String S) {
    StringBuilder sb = new StringBuilder();
    int right = 0;
    int left = 0;
    int count = 0;
    while (right < S.length()) {
      if (S.charAt(right) != S.charAt(left)) {
        sb.append(S.charAt(left));
        if (count != 0)
          sb.append(count);
        left = right;
      } else {
        count = 0;
        while (right < S.length() && S.charAt(right) == S.charAt(left)) {
          right++;
          count++;
        }
      }
    }
    sb.append(S.charAt(left));
    if (count != 0)
      sb.append(count);

    return sb.length() > S.length() ? S : sb.toString();
  }
}
