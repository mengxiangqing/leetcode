import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solutio {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        do {
            stack1.add(pushed[i++]);

        } while (stack1.peek() != popped[j]);

        return false;
    }
}
// @lc code=end
