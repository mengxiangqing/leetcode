import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class sanfor {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param st string字符串
     * @return string字符串
     */
    public String get_substr(String st) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < st.length();) {
                int end = i + 3 > st.length() ? st.length() : i + 3;
                String temp = st.substring(i, end);
                // 如果是重复串，则跳过
                if (isThird(temp)) {
                    flag = true;
                    i += 3;
                } else {
                    // 否则
                    sb.append(st.charAt(i));
                    i++;
                }
            }
            st = sb.toString();
            sb.delete(0, sb.length());
        }
        return st;
    }

    // 判断str中字符是否都相同
    public boolean isThird(String str) {
        if (str.length() < 3)
            return false;
        char s1 = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != s1) {
                return false;
            }
        }
        return true;
    }

    public String substr(String a, String b) {
        if (a.length() == b.length() && isSubStr(a, b)) {
            return a;
        }
        int minLen = b.length();
        String res = "";
        for (int i = minLen; i < a.length(); i++) {
            for (int j = 0; j + i < a.length(); j++) {
                String temp = a.substring(j, j + i);
                if (isSubStr(temp, b)) {
                    return temp;
                }
            }
        }

        return res;
    }

    public boolean isSubStr(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    public int histogram_max_area(int[] histogram) {
        int n = histogram.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // 单调找
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * histogram[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        sanfor sf = new sanfor();
        int res = sf.histogram_max_area(new int[] { 2, 9, 5, 7, 3 });
        System.out.println(res);
    }

}
