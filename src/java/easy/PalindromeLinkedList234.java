package easy;

import util.ListNode;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        for (;fast != null && fast.next != null;) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode current = slow;
        ListNode last = null;
        for (; current != null;) {
            ListNode next = current.next;
            current.next = last;
            last = current;
            current = next;
        }

        for (;head != null && last != null;) {
            if (head.val != last.val) {
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }
}
