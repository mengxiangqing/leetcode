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
        System.out.println(2 & 3);
        System.out.println(~1);
        System.out.println(2 | 3);
        System.out.println(2 ^ 3);
        System.out.println(~-3);
        int i = 3;
        String result = new String();
        switch (i) {
            case 1:
                result += "him";
            case 2:
                result += "her";

            default:
                result += "me";
                break;
        }

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
