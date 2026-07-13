class PrefixTree {

    private val root = TrieNode()

    fun insert(word: String) {
        var curr = root

        for (ch in word) {
            curr.children.putIfAbsent(ch, TrieNode())
            curr = curr.children[ch]!!
        }

        curr.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var curr = root

        for (ch in word) {
            if (!curr.children.contains(ch)) return false
            curr = curr.children[ch]!!
        }

        return curr.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root

        for (ch in prefix) {
            if (!curr.children.contains(ch)) return false
            curr = curr.children[ch]!!
        }

        return true
    }

    private class TrieNode {

        var isEndOfWord = false
        val children = mutableMapOf<Char, TrieNode>()
    }
}