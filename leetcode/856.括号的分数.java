import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution{
    public int scoreOfParentheses(String s) {
        int res = 0;
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // 左括号 直接进栈
                stack.addFirst(s.substring(i, i + 1));
            } else {
                // 有括号 必须出栈找到一个对应的左括号，并将中间的数字计算
                List<Integer> list = new ArrayList<>();
                while (!"(".equals(stack.getFirst())) {
                    list.add(Integer.parseInt(stack.removeFirst()));
                }
                int temp = 0;
                for (Integer num : list) {
                    temp += num;
                }
                // 去掉左括号
                stack.removeFirst();
                stack.addFirst(String.valueOf(temp == 0 ? 1 : temp * 2));
            }

        }
        if (stack.size() == 1) {
            res = Integer.parseInt(stack.getFirst());
        } else {
            while (!stack.isEmpty()) {
                res += Integer.parseInt(stack.removeFirst());
            }
        }
        return res;
    }
}

// @lc code=end
