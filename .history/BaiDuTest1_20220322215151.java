import java.util.HashMap;
import java.util.Scanner;

public class BaiDuTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();
        int len = a.length();
        // 从长度len-1 到 1遍历
        label1:
        for (int i = len - 1; i > 0; i--) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            //遍历子串
            for (int j = 0; j < len; j++) {
                HashMap<String, Integer> hashMap2 = new HashMap<>();
                String str = a.substring(j, j + i);
                //计算字符串中 0和1 的个数
                int[] ZeroAndOne = countZeroAndOne(str);
                //构造字符串
                String s = "zero" + ZeroAndOne[0] + "one" + ZeroAndOne[1];
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
                //有两个字符串 0 1个数相同
                if (hashMap.get(s) == 2) {
                    // 获取前一个的index
                    int preIndex = hashMap2.get(s);
                    System.out.println((j+1)+" "+(j+i+1)+" " +(preIndex+1)+" "+ (preIndex+i+1));
                    break label1;
                } else
                    hashMap2.put(s, j);


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
    public int getZero() {
        return zero;
    }
    public void setZero(int zero) {
        this.zero = zero;
    }
    public int getOne() {
        return one;
    }
    public void setOne(int one) {
        this.one = one;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

}