package 链表.回文链表

import common.ListNode

class IsPalindrome {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return false
        val list = mutableListOf<Int>()
        var node = head
        while (node != null) {
            list.add(node.`val`)
            node = node.next
        }
        var left = 0
        var right = list.size - 1
        while (left < right) {
            if (list[left] != list[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
}