/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { -10,-10 }, { -9,-9}, { 23, 30, 34, 60 } };
        int target = 21;
        Solutio S = new Solutio();
        System.out.println( S.searchMatrix(matrix, target));


    }
}
