/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    private Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        this.root.insert(word);
    }

    public boolean search(String word) {
        return dfs(this.root, word, 0);

    }

    public boolean dfs(Trie node, String word, int index) {
        if (index == word.length())
            return node.isEnd();
        char ch = word.charAt(index);
        // 如果ch是字母
        if (Character.isLetter(ch)) {
            int childrenIndex = ch - 'a';
            Trie child = node.getChildren()[childrenIndex];
            if (child != null && dfs(child, word, index + 1)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if(child!=null && dfs(child, word, index+1))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            int index = ch - 'a';
            if (node.children[index] == null)
                return null;
            node = node.children[index];
        }
        return node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
