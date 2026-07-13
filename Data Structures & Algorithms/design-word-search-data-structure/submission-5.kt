class WordDictionary {

    private val root = TrieNode()

    fun addWord(word: String) {
        var curr = root

        for (ch in word) {
            curr.children.putIfAbsent(ch, TrieNode())
            curr = curr.children[ch]!!
        }

        curr.word = true
    }

    fun search(word: String): Boolean {
        var curr = root

        for ((index, ch) in word.withIndex()) {
            if (ch != '.') {
                if (!curr.children.contains(ch)) return false
                curr = curr.children[ch]!!
            } else {
                if (curr.children.isEmpty()) return false
                val newCurr = TrieNode()
                var isWord = false

                for (entry in curr.children) {
                    newCurr.children.putAll(entry.component2().children)
                    isWord = entry.component2().word
                }

                curr = newCurr
                curr.word = isWord
            }
        }

        return curr.word
    }

    private class TrieNode {

        var word = false
        var children = mutableMapOf<Char, TrieNode>()
    }
}