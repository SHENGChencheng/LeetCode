package 图论.实现Trie前缀树

class Trie {

    private class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var isEndOfWord = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (ch in word) {
            val index = ch - 'a'
            if (node.children[index] == null) {
                node.children[index] = TrieNode()
            }
            node = node.children[index]!!
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (ch in word) {
            val index = ch - 'a'
            if (node.children[index] == null) return false
            node = node.children[index]!!
        }
        return node.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (ch in prefix) {
            val index = ch - 'a'
            if (node.children[index] == null) return false
            node = node.children[index]!!
        }
        return true
    }
}