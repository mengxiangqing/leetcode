/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { {1,4 }, { 0,4 }, { 8,10 },{15,18} };
        // int[][] m = { { 7 }, { 9 }, { 6 } };
        int n = 3;
        Solutio S = new Solutio();
        int[][] m = S.merge(matrix);
        System.out.println(m.toString());

    }
}
