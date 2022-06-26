import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 程序员面试金典 {

  public static void main(String[] args) {
    Solutio solution = new Solutio();
    String S = "ds sdfs afs sdfa dfssf asdf             ";
    int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
    int[] num = {1, 2, 3, 3, 2, 1};
    ListNode head = createList(num);
    ListNode result = solution.removeDuplicateNodes(head);

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

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solutio {

  /**
   * 移除重复结点
   * @param head
   * @return
   */
  public ListNode removeDuplicateNodes1(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = head;
    ListNode pre = head;
    ListNode q = head.next;
    //p指向每一个不同数字的第一位，慢慢从头往后走
    // q是遍历指针
    while (p != null) {
      pre = p;
      q = p.next;
      while (q != null) {
        while (q!=null&&p!=null&&q.val == p.val) {
          pre.next = q.next;
          q = pre.next;
        }
        if(pre!=null)pre = pre.next;
        if(q!=null)q = q.next;
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
   * @param matrix
   */
  public boolean isFlipedString(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    if (s1.length() == 0 && s2.length() == 0) {
      return true;
    }
    //拼接两个s2，如果是s2是s1旋转后，则肯定包含一个s1
    String s = s2 + s2;
    return s.contains(s1);
  }

  /**
   * 面试题 01.08. 零矩阵
   * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
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
        if (a[i] == 1 || b[j] == 1) matrix[i][j] = 0;
      }
    }
  }

  /**
   * 面试题1.6 旋转矩阵
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
   * @param s1
   * @param s2
   * @return
   */
  public boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    Map<Character, Integer> sMap1 = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      sMap1.put(c1, sMap1.getOrDefault(c1, 0) + 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char c2 = s2.charAt(i);
      sMap1.put(c2, sMap1.getOrDefault(c2, 0) - 1);
      if (sMap1.get(c2) < 0) return false;
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
      } else arr[right--] = arr[left];

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
    //偶数字符串，则不能有字符是奇数个
    if (s.length() % 2 == 0) {
      int count = 0;
      for (char c : map.keySet()) {
        if (map.get(c) % 2 == 1) count++;
        if (count > 0) return false;
      }
      return true;
    } else {
      //只能有一个字符是奇数个
      int count = 0;
      for (char c : map.keySet()) {
        if (map.get(c) % 2 == 1) count++;
        if (count > 1) return false;
      }
      return true;
    }
  }

  /**
   * 一次编辑
   * @param first
   * @param second
   * @return
   */
  public boolean oneEditAway(String first, String second) {
    // 看看长度差值
    int len1 = first.length();
    int len2 = second.length();
    //s1 是长的，s2 是短串
    String s1 = len1 > len2 ? first : second;
    String s2 = s1.equals(first) ? second : first;
    len1 = s1.length();
    len2 = s2.length();
    if (Math.abs(len1 - len2) > 1) return false;
    if (s1.equals("") || s2.equals("")) return true;
    boolean oneEdit = false; //表示是否操作过一次
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
        if (index2 == len2) return true;
        if (s1.charAt(index1) == s2.charAt(index2)) {
          index1++;
          index2++;
        } else {
          if (oneEdit) return false; else {
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
        if (count != 0) sb.append(count);
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
    if (count != 0) sb.append(count);

    return sb.length() > S.length() ? S : sb.toString();
  }
}
