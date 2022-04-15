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
        while (i < pushed.length || j < pushed.length)
        {
            if (stack1.size() == 0)
                stack1.addFirst(pushed[i++]);
            if (stack1.getFirst() == popped[j]) {
                stack1.removeFirst();
                j++;
            }
            else {
                if (i >= pushed.length)
                    return false;
                stack1.addFirst(pushed[i++]);
            }
        }
        return true;
    }
}
// @lc code=end
