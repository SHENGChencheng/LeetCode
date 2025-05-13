package 链表.环形链表

import common.ListNode

class HasCycle {
    fun hasCycle(head: ListNode?): Boolean {
        val visited = mutableSetOf<ListNode>()
        var pos = head
        while (pos != null) {
            if (visited.contains(pos)) {
                return true
            }
            visited.add(pos)
            pos = pos.next
        }
        return false
    }
}