import java.lang.String;
import java.util.*;

public class 剑指offer {
    public static void main(String[] args) {
        剑指47 jz = new 剑指47();
        int[] nums = new int[] { 10,26,30,31,47,60 };

        jz.twoSum(nums,40);

    }
}

class 剑指47 {
    public int[] twoSum(int[] nums, int target) {
        int end;
        for (end = nums.length - 1; end >= 0; end--) {
            if (nums[end] < target)
                break;
        }
        //肯定是[0,end]之间
        for (int i = 0; i < end; i++) {
            int res = search(nums, i + 1, end, target - nums[i]);
            if ( res!= -1) {
                return new int[] { nums[i], res };
            }
        }
        return nums;
    }
    //在数组的start 和 end 之间二分查找target
    public static int search(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return -1;
    }
}

class 剑指21 {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}

class 剑指22 {
    // 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
    public ListNode getKthFromEnd(ListNode head, int k) {
        int i = 0;
        ListNode p = head;
        ListNode q = head;
        while (i < k) {
            p = p.next;
            i++;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }

        return q;
    }
}

class 剑指18 {
    // 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    // 返回删除后的链表的头节点。
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = dummy.next;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                break;
            }
            pre = pre.next;
            p = p.next;
        }
        return dummy.next;
    }
}

class 剑指48 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1)
            return len;
        int max = 0;
        int temp = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < len; j++) {
            int i = hashMap.getOrDefault(s.charAt(j), -1);
            temp = temp < j - i ? temp + 1 : j - i;
            max = Math.max(max, j - i);
        }

        return max;
    }
}

class Trans46 {
    // 剑指 Offer 46. 把数字翻译成字符串
    public int translateNum(int num) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        trackBack(String.valueOf(num), list, sb, 0);
        return list.size();
    }

    public int translateNumDP(int num) {
        String str = String.valueOf(num);
        if (str.length() < 2)
            return str.length();
        // 以i结尾的字符串能翻译的种类
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (Integer.valueOf(str.substring(0, 2)) > 9 && Integer.valueOf(str.substring(0, 2)) < 26) {
            dp[1] += 1;
        }
        for (int i = 2; i < str.length(); i++) {
            dp[i] = dp[i - 1];
            if (Integer.valueOf(str.substring(i - 1, i + 1)) > 9 && Integer.valueOf(str.substring(i - 1, i + 1)) < 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[str.length() - 1];

    }

    private void trackBack(String num, List<String> list, StringBuilder sb, int index) {
        if (index == num.length()) {
            String str = new String(sb);
            if (!list.contains(str))
                list.add(str);
            return;
        }

        for (int j = index + 1; j <= index + 2 && j <= num.length(); j++) {
            String sTmp = num.substring(index, j);
            if (Integer.parseInt(sTmp) <= 25) {
                if (sTmp.length() > 1) {
                    if (sTmp.charAt(0) == '0')
                        break;
                }
                sb.append((char) (Integer.parseInt(sTmp) + 'a'));
                trackBack(num, list, sb, j);
                sb.deleteCharAt(sb.length() - 1);

            }

        }
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

// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) // 这个条件就不用特意判断head是不是空了
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

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random
 * 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CopyComplixList {
    HashMap<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        // 新链表头结点
        Node newDummy = new Node(0);
        Node q = newDummy;
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            q.next = newNode;
            hashMap.put(p, newNode);
            q = q.next;
            p = p.next;
        }
        q = newDummy.next;
        while (head != null) {
            if (head.random != null) {
                q.random = hashMap.get(head.random);
            }
            head = head.next;
            q = q.next;
        }
        return newDummy.next;
    }
}

class StringReverse {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s.substring(n));
        sb.append(s.substring(0, n));
        return sb.toString();
    }

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return nums[i];
            } else {
                hashMap.put(nums[i], 1);

            }
        }
        return 0;
    }

    public int missingNumber(int[] nums) {
        int num = 1;
        if (nums.length == 1) {
            if (nums[0] == 0)
                return 1;
            else
                return 0;
        } else {
            int n = nums.length;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    num = nums[i] + 1;
                }
            }
        }
        return num;
    }

    public char firstUniqChar(String s) {
        if (s.length() == 0)
            return ' ';
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);

        }
        return ' ';
    }
}

class testChar {
    public static void main(String[] args) {
        StringReverse sr = new StringReverse();
        System.out.println(sr.firstUniqChar("leetcode"));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class BinTree {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[] {};
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addFirst(root);
        while (!que.isEmpty()) {
            TreeNode node = que.removeLast();
            ans.add(node.val);
            if (node.left != null)
                que.addFirst(node.left);
            if (node.right != null)
                que.addFirst(node.right);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addFirst(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.removeLast();
                temp.add(node.val);
                if (node.left != null)
                    que.addFirst(node.left);
                if (node.right != null)
                    que.addFirst(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addFirst(root);

        while (!que.isEmpty()) {
            int size = que.size();
            LinkedList<Integer> temp = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.removeLast();
                if (ans.size() % 2 == 0)
                    temp.addLast(node.val);
                else
                    temp.addFirst(node.val);

                if (node.left != null)
                    que.addFirst(node.left);
                if (node.right != null)
                    que.addFirst(node.right);

            }
            ans.add(temp);
        }
        return ans;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null)
            return false;
        // 先遍历a，等找到一个与B根相同的就同步遍历
        Deque<TreeNode> que = new ArrayDeque<>();
        que.addLast(A);
        while (!que.isEmpty()) {
            TreeNode p = que.removeFirst();
            if (p.val == B.val) {
                if (dfs(p, B))
                    return true;
            }
            if (p.left != null)
                que.addLast(p.left);
            if (p.right != null)
                que.addLast(p.right);
        }
        return false;
    }

    private boolean dfs(TreeNode p, TreeNode b) {
        if (b == null)
            return true;
        else if (p == null)
            return false;
        else if (p.val == b.val) {
            return (dfs(p.left, b.left) && dfs(p.right, b.right));
        } else
            return false;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode a = root.left;
        TreeNode b = root.right;
        return isSymmetricTwo(a, b);

    }

    private boolean isSymmetricTwo(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;
        else if (a.val != b.val)
            return false;
        else
            return isSymmetricTwo(a.left, b.right) && isSymmetricTwo(a.right, b.left);
    }

    public int maxValue(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    }
                    if (j > 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}