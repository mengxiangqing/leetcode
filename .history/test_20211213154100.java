/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        int[][] matrix = { { -10,-10 }, { -9,-9}, { -8,-6} ,{-4,-2},{0,1},{3,3},{5,5},{6,8}};
        int target = 0;
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        int[] nums = { 1,1,1,2,2,3,3,3,3};
        Solutio S = new Solutio();
        System.out.println(S.removeDuplicates(nums));



    }
}
