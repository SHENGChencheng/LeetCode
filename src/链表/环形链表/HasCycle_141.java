package 链表.环形链表;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode pos = head;
        while (pos != null) {
            if (visited.contains(pos)) {
                return true;
            }
            visited.add(pos);
            pos = pos.next;
        }
        return false;
    }
}
