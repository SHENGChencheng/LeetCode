package 链表.反转链表

import common.ListNode
import common.createList
import common.printList

class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var node = head
        while (node != null) {
            val next = node.next
            node.next = pre
            pre = node
            node = next
        }
        return pre
    }
}

fun main() {
    val solution = ReverseList()

    // 测试用例1: 普通链表
    val list1 = createList(1, 2, 3, 4, 5)
    println("原链表1:")
    printList(list1)
    val reversed1 = solution.reverseList(list1)
    println("反转后:")
    printList(reversed1)

    // 测试用例2: 空链表
    val list2: ListNode? = null
    println("\n原链表2: 空链表")
    val reversed2 = solution.reverseList(list2)
    println("反转后:")
    printList(reversed2)

    // 测试用例3: 单节点链表
    val list3 = createList(1)
    println("\n原链表3:")
    printList(list3)
    val reversed3 = solution.reverseList(list3)
    println("反转后:")
    printList(reversed3)

    // 测试用例4: 双节点链表
    val list4 = createList(1, 2)
    println("\n原链表4:")
    printList(list4)
    val reversed4 = solution.reverseList(list4)
    println("反转后:")
    printList(reversed4)

    // 测试用例5: 长链表
    val list5 = createList(1, 3, 5, 7, 9, 11, 13)
    println("\n原链表5:")
    printList(list5)
    val reversed5 = solution.reverseList(list5)
    println("反转后:")
    printList(reversed5)
}