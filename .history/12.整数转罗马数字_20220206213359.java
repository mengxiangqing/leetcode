/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        String res = "";
        while (num > 0) {
            if (num >= 1000) {
                int count = num / 1000;

                for (int i = 0; i < count; i++) {
                    res += "M";

                }
                num %= 1000;
            } else if (num < 1000 && num >= 500) {
                int count = num / 500;
                if (num >= 900)
                    res += "CM";
                else {
                    for (int i = 0; i < count; i++) {
                        res += "D";
                    }
                }
                num %= 500;
            } else if (num < 500 && num >= 100) {
                int count = num / 100;
                if (count >= 400)
                    res += "CD";
                else
                    for (int i = 0; i < count; i++) {
                        res += "C";
                    }
                num %= 100;
            } else if (num < 100 && num >= 50) {
                int count = num / 50;
                if(count)
                for (int i = 0; i < count; i++) {
                    res += "L";
                }
                num %= 50;
            } else if (num < 50 && num >= 10) {
                int count = num / 10;
                for (int i = 0; i < count; i++) {
                    res += "X";
                }
                num %= 10;
            } else if (num < 10 && num >= 5) {
                int count = num / 5;
                for (int i = 0; i < count; i++) {
                    res += "V";
                }
                num %= 5;
            } else if (num < 5 && num >= 1) {
                int count = num / 1;
                for (int i = 0; i < count; i++) {
                    res += "I";
                }
                num %= 1;
            }
        }
        return res;
    }
}
// @lc code=end
