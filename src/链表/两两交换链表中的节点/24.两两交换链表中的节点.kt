package 链表.两两交换链表中的节点

import common.ListNode

class SwapPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var pre = dummy
        while (pre.next != null && pre.next?.next != null) {
            val first = pre.next
            val second = pre.next?.next
            first?.next = second?.next
            second?.next = first
            pre.next = second
            pre = first!!
        }
        return dummy.next
    }
}