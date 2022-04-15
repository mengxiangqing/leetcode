import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        int i = 0;
        for (int num1 : pushed) {
            stack1.addFirst(num1);
            while (!stack1.isEmpty() && stack1.getFirst() == popped[i]) {
                stack1.removeFirst();
                i++;
            }
        }
        return stack1.isEmpty();
    }
}
// @lc code=end
