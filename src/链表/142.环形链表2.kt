package 链表

import common.ListNode

class DetectCycle {
    fun detectCycle(head: ListNode?): ListNode? {
        val visited = mutableSetOf<ListNode>()
        var pos = head
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos
            }
            visited.add(pos)
            pos = pos.next
        }
        return null
    }
}