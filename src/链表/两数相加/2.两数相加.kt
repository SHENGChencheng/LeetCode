package 链表.两数相加

import common.ListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyNode = ListNode(0)
        var p = l1
        var q = l2
        var cur = dummyNode
        var carry = 0
        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = x + y + carry
            carry = sum / 10
            cur.next = ListNode(sum % 10)
            cur = cur.next!!
            p = p?.next
            q = q?.next
        }
        if (carry > 0) {
            cur.next = ListNode(carry)
        }
        return dummyNode.next
    }
}