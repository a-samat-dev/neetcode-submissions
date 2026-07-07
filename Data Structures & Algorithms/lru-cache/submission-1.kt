class LRUCache(private val capacity: Int) {

    private val map = mutableMapOf<Int, Node>()
    private val head = Node(0, 0) // dummy LRU side
    private val tail = Node(0, 0) // dummy MRU side

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        insertAtTail(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val existing = map[key]

        if (existing != null) {
            existing.value = value
            remove(existing)
            insertAtTail(existing)
            return
        }

        val node = Node(key, value)
        map[key] = node
        insertAtTail(node)

        if (map.size > capacity) {
            val lru = head.next!!
            remove(lru)
            map.remove(lru.key)
        }
    }

    private fun remove(node: Node) {
        val prev = node.prev!!
        val next = node.next!!

        prev.next = next
        next.prev = prev

        node.prev = null
        node.next = null
    }

    private fun insertAtTail(node: Node) {
        val prev = tail.prev!!

        prev.next = node
        node.prev = prev
        node.next = tail
        tail.prev = node
    }

    private data class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}