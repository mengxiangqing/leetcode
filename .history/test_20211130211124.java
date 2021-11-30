/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { 1,2,3,4 }, { 5,6,7,8 }, { 9,10,11,12 } };
        int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Solutio S = new Solutio();
        S.spiralOrder(m);
        S.spiralOrder(matrix);

    }
}
