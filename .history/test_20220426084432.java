import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
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


        int a[][] = { { 2, 3 }, { 2, 4 } };
        Soluti s = new Soluti();
        s.projectionArea(a);


    }

    public static int[] nextLargerNodes() {
        List<Integer> list = new ArrayList<>(List.of(2,1,5));
        // 链表转数组
        // System.out.println(Arrays.toString(list.toArray()));
        // 存放数值和下标的栈 【val,index】
        Deque<int[]> que = new ArrayDeque<>();
        que.addFirst(new int[] { list.get(0), 0 });
        int[] res = new int[list.size()];
        for (int i = 1; i < res.length; i++) {
            if (list.get(i) <= que.getFirst()[0])
                que.addFirst(new int[] { list.get(i), i });
            else {
                while (!que.isEmpty()&&list.get(i) > que.getFirst()[0]) {
                    res[que.getFirst()[1]] = list.get(i);
                    que.removeFirst();
                }
                que.addFirst(new int[] { list.get(i), i });
            }
        }
        return res;
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
