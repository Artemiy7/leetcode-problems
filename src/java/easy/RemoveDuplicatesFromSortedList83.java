package easy;

import util.ListNode;

public class RemoveDuplicatesFromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode prev = head;
        head = head.next;


        while (head != null) {
            if (prev.val == head.val) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        System.gc();
        return listNode.next;
    }
}
