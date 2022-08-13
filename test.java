import java.util.TreeSet;

/**
 * DEBUG测试类
 */

public class test {

        public static void main(String[] args) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                TreeSet<Integer> subSet = new TreeSet<Integer>();
                for(int i=606;i<613;i++){
                    if(i%2==0){
                     set.add(i);
                     }
                 }
                subSet = (TreeSet)set.subSet(608,true,611,true);
                set.add(609);
                System.out.println(set + " " + subSet);

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

