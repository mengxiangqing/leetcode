import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();
    public CQueue() {

    }

    public void appendTail(int value) {

    }

    public int deleteHead() {
        if (stack2.size() == 0) {
            if (stack1.size() != 0)
            {
                //将栈一的所有元素出给栈2
                while (stack1.size() > 0) {
                    stack2.addFirst(stack1.removeFirst());
                }
                return stack2.removeFirst();

                }
            else
                return -1;
        } else {

        }

    }
}