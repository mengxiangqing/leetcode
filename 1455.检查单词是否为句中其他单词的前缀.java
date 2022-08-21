/*
 * @lc app=leetcode.cn id=1455 lang=java
 *
 * [1455] 检查单词是否为句中其他单词的前缀
 */

// @lc code=start
class Solution{
    public int isPrefixOfWord(String sentence, String searchWord) {
        int len = searchWord.length();
        int index = 0;
        int words = 0;

        for (index = 0; index < sentence.length(); index++) {
            if (sentence.charAt(index) == ' ') {
                words++;
            } else {
                if (sentence.charAt(index) == searchWord.charAt(0)
                        && (index == 0 || sentence.charAt(index - 1) == ' ')) {
                    int j = 0;
                    while (sentence.charAt(index) == searchWord.charAt(j)) {
                        j++;
                        index++;
                        // 待匹配字符串已完
                        if (j == len) {

                                return words + 1;


                        }
                    }
                    index--;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
