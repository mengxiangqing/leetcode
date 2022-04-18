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
        Codec code = new Codec();
        TreeNode root= code.deserialize("[1,2,3,null,null,4,5]");
        code.serialize(root);


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
