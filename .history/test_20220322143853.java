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
        String str = "aa";
        // Solutio S = new Solutio();
        // String res;
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> num3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> num4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));
        triangle.add(num1);
        triangle.add(num2);
        triangle.add(num3);
        triangle.add(num4);
        int[] nums = { 0, 1, 0, 3, 2, 3 };
        String[] strs = { "word", "good", "best", "good" };
        int tmp = 2;
        int cmp = 3;
        System.out.println(tmp = 3);
        // S.findSubstring("wordgoodgoodgoodbestword", strs);
        int[] test = nums;
        nums[0] = 2;
        System.out.println(test[0]);
        char[] c = str.toCharArray();
        System.out.println(new String(c));
    }
}

class MinStack {
    private int minData;
    private Deque<Integer> MinStack;
    private Deque<Integer> statck;

    /** initialize your data structure here. */
    public MinStack() {
        minData = Integer.MAX_VALUE;
        MinStack = new ArrayDeque<>();
        statck = new ArrayDeque<>();
    }

    public void push(int x) {
        if (MinStack.isEmpty())
            MinStack.addFirst(x);
        else {
            if (x < MinStack.getFirst()) {
                MinStack.addFirst(x);
            }else MinStack.addFirst(MinStack.getFirst());
        }
        statck.addFirst(x);

    }

    public void pop() {

        int data =statck.removeFirst();
        if (data == MinStack.getFirst()) {
            MinStack.removeFirst();
        }
    }

    public int top() {
        int data =statck.removeFirst();

            MinStack.removeFirst();

        return data;
    }

    public int min() {
        return null;
        return MinStack.getFirst();
    }
}
