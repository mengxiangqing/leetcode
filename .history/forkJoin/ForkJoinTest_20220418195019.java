package forkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class ForkJoinTest {
    public static void main(String[] args) {

    }
}

class Counter extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;



    @Override
    protected Integer compute() {
        // TODO Auto-generated method stub
        return null;
    }

}
