package 链表.排序链表

import common.ListNode

class SortList {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var slow = head
        var fast = head.next
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        val mid = slow?.next
        slow?.next = null
        val left = sortList(head)
        val right = sortList(mid)
        return merge(left, right)
    }

    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var cur = dummy
        var l = left
        var r = right
        while (l != null && r != null) {
            when {
                l.`val` < r.`val` -> {
                    cur.next = l
                    l = l.next
                    cur = cur.next!!
                }
                else -> {
                    cur.next = r
                    r = r.next
                    cur = cur.next!!
                }
            }
        }
        cur.next = l ?: r
        return dummy.next
    }
}