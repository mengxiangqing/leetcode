public class BaiDuTest1 {


    private int[] countZeroAndOne(String str) {
        int[] ans = new int[2];
        for (char c : str.toCharArray()) {
            ans[c - '0']++;
        }
        return ans;
    }
}

