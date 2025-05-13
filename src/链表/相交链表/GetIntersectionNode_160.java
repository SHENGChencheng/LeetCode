package 链表.相交链表;

import common.ListNode;

public class GetIntersectionNode_160 {
    public ListNode getInterSectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
//        假设：
//        链表 A 的长度为 a + c（a 是 A 独有部分，c 是交集部分）
//        链表 B 的长度为 b + c（b 是 B 独有部分）
//        两个指针会分别走完：
//        pA: a + c + b
//        pB: b + c + a
//        总长度一样，指针会在第一个交点处相遇，或者都变成 null。
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
