package 链表.随机链表的复制

import common.Node

class CopyRandomList {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        // 复制节点
        var cur = node
        while (cur != null) {
            val copy = Node(cur.`val`)
            copy.next = cur.next
            cur.next = copy
            cur = copy.next
        }
        // 复制随机指针
        cur = node
        while (cur != null) {
            if (cur.random != null) {
                cur.next?.random = cur.random?.next
            }
            cur = cur.next?.next
        }
        // 拆分链表
        cur = node
        val dummy = Node(0)
        var copyCur = dummy
        while (cur != null) {
            val next = cur.next?.next
            copyCur.next = cur.next
            copyCur = cur.next!!
            cur.next = next
            cur = next
        }
        return dummy.next
    }
}