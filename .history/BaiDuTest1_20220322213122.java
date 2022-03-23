import java.util.HashMap;
import java.util.Scanner;

public class BaiDuTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();
        int len = a.length();
        // 从长度i忘1遍历
        for (int i = len - 1; i > 0; i--) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < len; j++) {
                String str = a.substring(j, j + i);
                hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
            }
        }
    }

    private int[] countZeroAndOne(String str) {
        int[] ans = new int[2];
        for (char c : str.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }
}
