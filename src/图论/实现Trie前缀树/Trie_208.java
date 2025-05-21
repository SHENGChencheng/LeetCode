package 图论.实现Trie前缀树;

public class Trie_208 {
    // 定义Trie节点
    private class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26个小写字母
        boolean isEndOfWord = false; // 是否为单词结尾
    }

    private TrieNode root;

    public Trie_208() {
        root = new TrieNode();
    }

    // 插入单词
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // 查找完整单词
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    // 判断是否有前缀
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // 辅助函数：返回前缀最后一个字符的节点
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}
