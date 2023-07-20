package medium;

import util.ListNode;

public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for (int i = 1; i <= n; ++i) {
            fast = fast.next;
        }

        if(fast == null)
            return slow.next;

        for (;fast.next != null;) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
