import java.util.ArrayDeque;
import java.util.Deque;

public class 剑指offer30包含min函数的栈 {

  //     ["MinStack","push","push","push","min","pop","top","min"]
  // [[],[-2],[0],[-3],[],[],[],[]]
  public static void main(String[] args) {
    MinStack ms = new MinStack();
    ms.push(-2);
    ms.push(0);
    ms.push(-3);
    int x = ms.minSS();
    System.out.println(x);
    ms.pop();
    System.out.println(ms.top());
    System.out.println(ms.minSS());
  }
}

class MinStack {

    // 记录当前最小值
   private Deque<Integer> minStack;
   private Deque<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
      minStack = new ArrayDeque<Integer>();
      stack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
      if (minStack.isEmpty()) minStack.addFirst(x);
      else {
        minStack.addFirst(minStack.getFirst() > x ? x : minStack.getFirst());
      }
      stack.addFirst(x);
    }

    public void pop() {
      stack.removeFirst();
      minStack.removeFirst();
    }

    public int top() {

      return stack.getFirst();
    }

    public int minSS() {
      return minStack.getFirst();
    }
  }

