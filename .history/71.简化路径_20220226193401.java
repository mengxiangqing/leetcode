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
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty())
                    stack.pollLast();
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.addLast(name);
                stack.off
            }
        }

    }
}
// @lc code=end
