import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        // Solutio s = new Solutio();
        // int[] nums = new int[] {9,11};
        // int k = 2;
        // s.maxSlidingWindow(nums, k);
        String s = new String("1");
        String s1 = s.intern();
        String s2 = "1";
        System.out.println(s1 == s2);
        System.out.println(s == s2);

        String s3 = new String("2") + new String("2");
        System.out.println(s3);
        String s5 = s3.intern();
        String s4 = "22";
        System.out.println(s4 == s3);
        System.out.println(s4 == s5);
        System.out.println(s3 == s5);

    }
}

class MinStack {
    private Deque<Integer> MinStack;
    private Deque<Integer> statck;

    /** initialize your data structure here. */
    public MinStack() {

        MinStack = new ArrayDeque<>();
        statck = new ArrayDeque<>();
    }

    public void push(int x) {
        if (MinStack.isEmpty() || (x < MinStack.getFirst())) {
            MinStack.addFirst(x);
        } else
            MinStack.addFirst(MinStack.getFirst());

        statck.addFirst(x);

    }

    public void pop() {

        statck.removeFirst();
        MinStack.removeFirst();

    }

    public int top() {

        return statck.getFirst();

    }

    public int min() {

        return MinStack.getFirst();

    }
}
