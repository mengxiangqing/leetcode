/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solutio {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";
        // num2每一位与num1相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            String temp = "0";
            // 乘几个num1就是几个num1相加
            for (int j = 0; j < num2.charAt(i) - '0'; j++) {

                temp = addStrings(num1, temp);
            }

            // 补充0
            StringBuilder sb = new StringBuilder(temp);
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);

            }
            res = addStrings(sb.toString(), res);
        }

        return res;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();

    }
}
// @lc code=end
