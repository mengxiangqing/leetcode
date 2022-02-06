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
                if (num >= 900){
                    res += "CM";
                    num %= 900;
                }
                else {
                    int count = num / 500;
                    for (int i = 0; i < count; i++) {
                        res += "D";
                    }
                    num %= 500;
                }
            } else if (num < 500 && num >= 100) {
                if (num >= 400){
                    res += "CD";
                    num %= 400;
                }
                else {
                    int count = num / 100;
                    for (int i = 0; i < count; i++) {
                        res += "C";
                    }
                    num %= 100;
                }
            } else if (num < 100 && num >= 50) {

                if (num >= 90){
                    res += "XC";
                    num %= 90;  
                }
                else {
                    int count = num / 50;
                    for (int i = 0; i < count; i++) {
                        res += "L";
                    }
                    num %= 50;
                }
            } else if (num < 50 && num >= 10) {
                if (num >= 40){
                    res += "XL";
                    num %= 40;
                }
                else {
                    int count = num / 10;
                    for (int i = 0; i < count; i++) {
                        res += "X";
                    }
                    num %= 10;
                }
            } else if (num < 10 && num >= 5) {
                if (num == 9){
                    res += "IX";
                    num %= 9;
                }
                else {
                    int count = num / 5;
                    for (int i = 0; i < count; i++) {
                        res += "V";
                    }
                    num %= 5;
                }
            } else if (num < 5 && num >= 1) {
                if (num == 4){
                    res += "IV";
                    num %= 4;
                }
                else {
                    int count = num / 1;
                    for (int i = 0; i < count; i++) {
                        res += "I";
                    }
                    num %= 1;
                }
            }
        }
        return res;
    }
}
// @lc code=end
