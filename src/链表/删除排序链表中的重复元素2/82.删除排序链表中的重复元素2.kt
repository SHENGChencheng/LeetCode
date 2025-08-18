package 链表.删除排序链表中的重复元素2

import common.ListNode

class DeleteDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head // 边界情况处理

        val dummy = ListNode(-1).apply { next = head }
        var current = dummy

        while (current.next != null && current.next?.next != null) {
            if (current.next!!.`val` == current.next!!.next!!.`val`) {
                val duplicateValue = current.next!!.`val`
                // 跳过所有重复节点
                while (current.next != null && current.next!!.`val` == duplicateValue) {
                    current.next = current.next!!.next
                }
            } else {
                current = current.next!!
            }
        }

        return dummy.next
    }
}
