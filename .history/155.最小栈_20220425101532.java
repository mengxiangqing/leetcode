import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.addFirst(val);
            minStack.add(val);
        } else {
            stack.addFirst(val);
            int curMin = minStack.getFirst();
            if (val < curMin) {
                minStack.addFirst(val);
            } else
                minStack.addFirst(curMin);
        }
    }

    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        minStack.removeFirst();
        return stack.removeFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
