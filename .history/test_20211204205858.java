/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { {1,2 }, { 3,5 }, { 6,7 },{8,10},{12,16} };
        int[] n = {4,8 };
        Solutio S = new Solutio();
        int[][] m = S.insert(matrix, n);
        System.out.println(m.toString());

    }
}
