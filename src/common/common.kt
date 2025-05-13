package common

// 链表
class ListNode(var `val`: Int) {
    @JvmField
    var next: ListNode? = null
}

// 辅助函数：打印链表
fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} ")
        current = current.next
    }
    println()
}

// 辅助函数：创建链表
fun createList(vararg values: Int): ListNode? {
    if (values.isEmpty()) return null
    val head = ListNode(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}

// 二叉树
class TreeNode(@JvmField var `val`: Int) {
    @JvmField
    var left: TreeNode? = null
    @JvmField
    var right: TreeNode? = null
}