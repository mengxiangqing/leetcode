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
        for (String str : wordList) {
            if (str.length() == word.length()) {

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

