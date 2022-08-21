import java.util.TreeSet;

/**
 * DEBUG测试类
 */

public class test {

        public static void main(String[] args) {
                Solution1455 so = new Solution1455();
                System.out.println(so.isPrefixOfWord("b bu bur burg burger", "burg"));


        }

        public static double sqrt() {
                double low = 1.4;
                double high = 1.5;
                double mid = 0;
                double flag = 0.0000000001;
                while (high - low > flag) {
                        mid = (low + high) / 2;
                        if (mid * mid > 2) {
                                high = mid;
                        } else
                                low = mid;
                }

                return mid;
        }

}
