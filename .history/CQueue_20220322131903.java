import java.util.*;

public class CQueue {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.addFirst(value);
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
            //两个都空
                return -1;
        } else {
            return stack2.removeFirst();
        }

    }
}

class test {
    public static void main(String[] args) {
        CQueue cq = new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.appendTail(3);
        cq.appendTail(4);
        cq.deleteHead();

    }
}