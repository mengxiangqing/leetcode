import java.util.HashMap;
import java.util.Scanner;

public class BaiDuTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();
        int len = a.length();
        // 从长度i忘1遍历
        label1:
        for (int i = len - 1; i > 0; i--) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < len; j++) {
                String str = a.substring(j, j + i);
                //计算字符串中 0和1 的个数
                int[] ZeroAndOne = countZeroAndOne(str);
                //构造字符串
                String s = "zero" + ZeroAndOne[0] + "one" + ZeroAndOne[1] + "index" + "j";
                hashMap.put(s.split("index")[0], hashMap.getOrDefault(s.split("index")[0], 0) + 1);
                if (hashMap.get(s.split("index")[0]) == 2) {
                    System.out.println();
                    break label1;
                }

            }
        }
    }

    private static int[] countZeroAndOne(String str) {
        int[] ans = new int[2];
        for (char c : str.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }
}

class Str {
    int zero;
    int one;
    int index;

}