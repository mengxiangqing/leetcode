/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { 1,3,5,7 }, {10,11,16,20 }, { 23,30,34,60 }};
        int target = 3;
        Solutio S = new Solutio();
        S.searchMatrix(matrix, target);


    }
}
