import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class wangyi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        // 处理输入值
        String[] inputs = input.substring(2, input.length() - 2).split("\\],\\[");

        Set<Integer> curKeys = new HashSet<>();
        List<List<Integer>> boxs = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] keyStr = inputs[i].substring(1, inputs[i].length() - 1).split(",");
            List<Integer> temp = new ArrayList<>();

            for (String str : keyStr) {
                if (!"".equals(str))
                    temp.add(Integer.valueOf(str));
            }

            boxs.add(temp);
        }
        // 总箱子数目
        int n = inputs.length;
        int count = 0;
        boolean[] isOpen = new boolean[n];
        // 先打开0号
        curKeys.addAll(boxs.get(0));
        isOpen[0] = true;
        count++;
        while (!curKeys.isEmpty()) {
            // 找到一个key
            int curKey = 0;
            for (int key : curKeys) {
                // 找到一个没用过的钥匙
                if (isOpen[key] == false) {
                    curKey = key;
                    curKeys.remove(key);
                    isOpen[key] = true;
                    count++;
                    break;
                }
            }
            // 将新打开的箱子中的钥匙放入钥匙包

            curKeys.addAll(boxs.get(curKey));

        }
        System.out.println(count == n);
    }
}
