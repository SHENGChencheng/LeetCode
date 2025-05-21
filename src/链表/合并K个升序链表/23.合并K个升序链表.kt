package 链表.合并K个升序链表

import common.ListNode
import java.util.PriorityQueue

class MergeKLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val heap = PriorityQueue<ListNode>(compareBy { it.`val` })
        lists.forEach { it?.let { heap.offer(it) } }
        val dummy = ListNode(0)
        var curr = dummy
        while (!heap.isEmpty()) {
            val node = heap.poll()
            curr.next = node
            curr = curr.next!!
            node.next?.let { heap.offer(it) }
        }
        return dummy.next
    }
}