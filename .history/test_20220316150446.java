import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * DEBUG测试类
 */

public class test {

    public static void main(String[] args) {
        String str = "aa";
        Solutio S = new Solutio();
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
        String[] strs = { "10", "0001", "111001", "1", "0" };
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.search("bad");
    }
}
