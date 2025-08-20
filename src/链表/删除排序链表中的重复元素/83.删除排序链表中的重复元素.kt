package 链表.删除排序链表中的重复元素

import common.ListNode

class DeleteDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        var curr = head
        while (curr?.next != null) {
            if (curr.`val` == curr.next!!.`val`) {
                curr.next = curr.next!!.next
            } else {
                curr = curr.next
            }
        }
        return head
    }
}