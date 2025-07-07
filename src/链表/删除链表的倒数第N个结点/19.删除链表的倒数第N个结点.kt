package 链表.删除链表的倒数第N个结点

import common.ListNode

class RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var slow = dummy
        for (i in 0 until n + 1) {
            fast = fast?.next
        }
        while (fast != null) {
            fast = fast.next
            slow = slow.next!!
        }
        slow.next = slow.next?.next
        return dummy.next
    }
}