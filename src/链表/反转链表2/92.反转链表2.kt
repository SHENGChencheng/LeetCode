package 链表.反转链表2

import common.ListNode

class ReverseBetween {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummyNode = ListNode(0)
        dummyNode.next = head
        var pre: ListNode? = dummyNode
        for (i in 0 until left - 1) {
            pre = pre?.next
        }
        val leftNode: ListNode? = pre?.next
        var rightNode: ListNode? = pre
        for (i in 0 until right - left + 1) {
            rightNode = rightNode?.next
        }
        val after: ListNode? = rightNode?.next
        pre?.next = null
        rightNode?.next = null
        reverseLinkedList(leftNode)
        pre?.next = rightNode
        leftNode?.next = after
        return dummyNode.next
    }

    private fun reverseLinkedList(head: ListNode?) {
        var pre: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = pre
            pre = curr
            curr = next
        }
    }
}