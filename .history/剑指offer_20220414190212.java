import java.lang.String;
import java.util.*;

public class 剑指offer {
    public static void main(String[] args) {
        // 剑指33 jz = new 剑指33();
        // int[] nums = new int[] { 1, 2, 5, 10, 6, 9, 4, 3 };
        // String str = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        // String[] data = str.substring(1, str.length() - 1).split(",");
        // jz.verifyPostorder(nums);
        int a = 13;
        int b = 14;
        while (b != 0) {
            int c = (a & b) << 1;// c=进位
            a ^= b;// a= 非进位和
            b = c;// b = 进位
        }
        System.out.println(a);
    }
}

class 剑指66 {
    public int[][] findContinuousSequence(int target) {
        if (target == 1)
            return new int[0][];
        List<List<Integer>> res = new ArrayList<>();
        int ban = target / 2 + 1;
        for (int i = ban; i > 1; i--) {
            List<Integer> temp = new ArrayList<>();
            int curSum = 0;
            for (int j = i; j >= 1; j--) {
                curSum += j;
                temp.add(j);
                if (curSum == target)
                    res.add(temp);
                else if (curSum > target)
                    break;

            }
        }
        int[][] ans = new int[res.size()][];
        int i = 0;
        for (List<Integer> list : res) {
            ans[i] = new int[list.size()];
            i++;
            int j = 0;
            for (Integer num : list) {
                ans[i][j] = num;
            }
        }
        return ans;
    }

    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0)
            return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}

class 剑指33 {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j != i)
                    b[i] *= a[j];
            }
        }
        return b;
    }

    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        // 现在n是两个只出现一次的数字的异或值
        int m = 1;
        // 自右往左找n中第一个1
        while ((n & m) == 0) {
            m <<= 1;
        }
        int x = 0;
        int y = 0;
        for (int num : nums) {
            if ((num & m) == 0)
                x ^= num;
            else
                y ^= num;
        }
        return new int[] { x, y };

    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length <= 1)
            return true;
        int n = postorder.length - 1;
        int left_index = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 找到第一个小于根节点的值，是左子树的根
            if (postorder[i] < postorder[n]) {
                left_index = i;
                break;
            }
        }
        boolean flag_left = true;
        // 判断有没有左子树
        if (left_index > 0) {
            // 判断左子树里面的结点是不是都小于根
            for (int i = 0; i < left_index + 1; i++) {
                if (postorder[n] < postorder[i])
                    flag_left = false;
            }
        }
        boolean flag_right = true;
        // 判断有没有右子树
        if (left_index < n - 1) {
            // 判断右子树里面的结点是不是都大于根
            for (int i = left_index + 1; i < n; i++) {
                if (postorder[n] > postorder[i])
                    flag_right = false;
            }
        }
        if (flag_left && flag_right &&
                verifyPostorder(Arrays.copyOfRange(postorder, 0, left_index + 1))
                && verifyPostorder(Arrays.copyOfRange(postorder, left_index + 1, n)))

            return true;
        return false;
    }
}

class 剑指64 {
    public int sumNums(int n) {
        // 通过短路来实现递归的结束条件
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

class 剑指40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length)
            return arr;
        if (k == 0)
            return new int[0];
        return quickSort(arr, k, 0, arr.length - 1);

    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l;
        int j = r;
        int temp = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= temp)
                j--;
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] <= temp)
                i++;
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        if (i > k)
            return quickSort(arr, k, l, i - 1);
        if (i < k)
            return quickSort(arr, k, i + 1, r);

        return Arrays.copyOf(arr, k);
    }
}

class 剑指45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return (o1 + o2).compareTo(o2 + o1);
            }

        });

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);

        }
        return sb.toString();
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int min = 20;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }
            if (i > 0 && nums[i] != 0 && nums[i] == nums[i - 1])
                return false;

        }
        if (max - min >= 5) {
            return false;
        }

        return true;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

class 剑指54 {
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        if (k == 0)
            return;
        if (--k == 0)
            res = root.val;
        dfs(root.left);
    }
}

class 剑指36 {
    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
    Deque<Node> que = new ArrayDeque<>();

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        treeToDoublyList(root.left);

        if (que.isEmpty()) {
            que.addLast(root);
        } else {
            que.getLast().right = root;
            root.left = que.getLast();
            que.addLast(root);
        }
        treeToDoublyList(root.right);
        que.getLast().right = que.getFirst();
        que.getFirst().left = que.getLast();
        return que.getFirst();
    }
}

class 剑指34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        dfs(res, root, target, path, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int target, List<Integer> path, int sum) {
        path.add(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));

        } else {

            if (root.left != null)
                dfs(res, root.left, target, path, sum);
            if (root.right != null)
                dfs(res, root.right, target, path, sum);
        }
        path.remove(path.size() - 1);

    }

    /**
     * 根据数组层次遍历生成二叉树
     *
     * @param data
     * @return
     */
    public TreeNode createTree(String[] data) {
        ArrayDeque<TreeNode> pre = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        pre.addLast(root);
        int index = 0;

        while (!pre.isEmpty()) {
            ArrayDeque<TreeNode> cur = new ArrayDeque<>();
            while (!pre.isEmpty()) {

                TreeNode node = pre.removeFirst();
                TreeNode left = null;
                TreeNode right = null;

                if (++index < data.length && !data[index].equals("null")) {
                    left = new TreeNode(Integer.parseInt(data[index]));
                    cur.addLast(left);
                }
                if (++index < data.length && !data[index].equals("null")) {
                    right = new TreeNode(Integer.parseInt(data[index]));
                    cur.addLast(right);
                }
                node.left = left;
                node.right = right;
            }
            pre = cur;
        }
        return root;
    }
}

class 剑指13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);

    }

    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // 因为题目规定了m n <=100
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j] == true)
            return 0;
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited)
                + dfs(i, j - 1, m, n, k, visited);
    }

}

class 剑指12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k])
            return false;
        if (k == words.length - 1)
            return true;
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }
}

class 剑指58 {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            // 找到首个空格
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            sb.append(s.substring(i + 1, j + 1) + " ");
            // 跨过多余空格
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return sb.toString().trim();

    }
}

class 剑指47 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target)
                i++;
            else if (s > target)
                j--;
            else
                return new int[] { nums[i], nums[j] };
        }
        return new int[0];
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
/*
 * class Node {
 * int val;
 * Node next;
 * Node random;
 *
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 * /**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random
 * 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
 * class CopyComplixList {
 * HashMap<Node, Node> hashMap = new HashMap<>();
 *
 * public Node copyRandomList(Node head) {
 * // 新链表头结点
 * Node newDummy = new Node(0);
 * Node q = newDummy;
 * Node p = head;
 * while (p != null) {
 * Node newNode = new Node(p.val);
 * q.next = newNode;
 * hashMap.put(p, newNode);
 * q = q.next;
 * p = p.next;
 * }
 * q = newDummy.next;
 * while (head != null) {
 * if (head.random != null) {
 * q.random = hashMap.get(head.random);
 * }
 * head = head.next;
 * q = q.next;
 * }
 * return newDummy.next;
 * }
 * }
 */

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