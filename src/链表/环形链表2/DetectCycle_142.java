package 链表.环形链表2;

import common.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> visited = new HashSet<>();
//        ListNode pos = head;
//        while (pos != null) {
//            if (visited.contains(pos)) {
//                return pos;
//            }
//            visited.add(pos);
//            pos = pos.next;
//        }
//        return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环, 2(a + b) = a + b + n * c
            // a = n * c - b
            // a 是链表头到入口的距离, b 是相遇点到入口的距离, c 是环的长度
            // 链表头到入口的距离 = 相遇点到环起点剩下的距离（即 c - b）
            // 相遇后, 一个从头开始, 一个从相遇点开始, 速度相同, 相遇点就是入口
            if (slow == fast) {
                // 找到入口
                ListNode pos = head;
                while (pos != slow) {
                    pos = pos.next;
                    slow = slow.next;
                }
                return pos;
            }
        }
        return null;
    }
}
