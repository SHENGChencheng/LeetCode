package 链表.合并两个有序链表

import common.ListNode

class MergeTwoLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        return when {
            list1 == null -> list2
            list2 == null -> list1
            list1.`val` < list2.`val` -> {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            }
            else -> {
                list2.next = mergeTwoLists(list1, list2.next)
                list2
            }
        }
    }

}