package 链表.相交链表

import common.ListNode

class GetIntersectionNode {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null
        var pA = headA
        var pB = headB
        while (pA != pB) {
            pA = if (pA == null) headB else pA.next
            pB = if (pB == null) headA else pB.next
        }
        return pA
    }
}