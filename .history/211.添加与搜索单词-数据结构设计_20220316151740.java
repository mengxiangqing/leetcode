import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    List<String> wordList = new ArrayList<>();

    public WordDictionary() {

    }

    public void addWord(String word) {
        wordList.add(word);

    }

    public boolean search(String word) {
        if (wordList.contains(word))
            return true;
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.')
                flag = true;
        }
        if (flag) {

            for (String str : wordList) {
                if (str.length() == word.length()) {
                    int i = 0;
                    int j = 0;
                    while (i < str.length()) {
                        if (str.charAt(i) == word.charAt(j) || word.charAt(j) == '.') {

                            j++;
                        }
                        i++;
                    }
                    if (i == j)
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
