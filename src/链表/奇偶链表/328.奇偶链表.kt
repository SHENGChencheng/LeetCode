package 链表.奇偶链表

import common.ListNode

class OddEvenList {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return head
        val evenHead = head.next
        var odd = head
        var even = evenHead
        while (even?.next != null) {
            odd?.next = even.next
            odd = odd?.next
            even.next = odd?.next
            even = even.next
        }
        odd?.next = evenHead
        return head
    }
}
