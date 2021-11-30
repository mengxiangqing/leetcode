/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { 1,2,3,4 }, { 5,6,7,8 }, { 9,10,11,12 } };
        int[][] m = { { 7 }, { 9}, { 6} };
        Solutio S = new Solutio();
        System.out.println(S.spiralOrder(m).toString());
        S.spiralOrder(matrix);

    }
}
