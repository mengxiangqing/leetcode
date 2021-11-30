/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Solutio S = new Solutio();
        S.spiralOrder(m);
        S.spiralOrder(matrix);

    }
}
