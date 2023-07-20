package easy;

import util.ListNode;

public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = head;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        if (head.val == val && head.next == null)
            return null;

        if (head.val == val && head.next != null) {
            head = head.next;
        }

        return head;
    }
}
