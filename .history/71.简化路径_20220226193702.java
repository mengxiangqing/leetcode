import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();//java中的栈用双端队列
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty())
                    stack.pollLast();
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.addLast(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty())
            sb.append('/');
        else {
            while (!stack.isEmpty()) {
                sb.append('/');
                sb.append(stack.pollFirst());
            }
        }
        return sb.toString();
    }
}
// @lc code=end
