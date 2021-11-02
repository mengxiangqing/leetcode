/**
 * test
 */
public class test {

    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        int num=0;
    
        String[] n = s.split(" ");
        for (int i = 0; i < n.length; i++) {
            if ("".equals(n[i])) {
                num++;
            }
        }

        System.out.println(n.length-num);
    }
}