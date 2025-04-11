package 链表

class LRUCache(capacity: Int) {
    inner class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    val dummy = Node(0, 0)
    val map = hashMapOf<Int, Node>()
    val capacity = capacity

    init {
        dummy.prev = dummy
        dummy.next = dummy
    }

    fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    fun pushNode(node: Node) {
        node.prev = dummy
        node.next = dummy.next
        node.prev?.next = node
        node.next?.prev = node
    }

    fun getNode(key: Int): Node? {
        if (!map.containsKey(key)) return null
        val node = map[key]!!
        removeNode(node)
        pushNode(node)
        return node
    }

    fun get(key: Int): Int {
        val node = getNode(key)
        return node?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        getNode(key)?.apply {
            this.value = value
            return
        }
        val node = Node(key, value)
        map[key] = node
        pushNode(node)
        if (map.size > capacity) {
            dummy.prev?.let {
                removeNode(it)
                map.remove(it.key)
            }
        }
    }
}