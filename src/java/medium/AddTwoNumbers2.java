package java.medium;

import util.ListNode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mem = 0;
        ListNode hook = new ListNode(0);
        ListNode l3 = hook;

        for (;l1 != null || l2 != null ;) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int res = val1 + val2 + mem;
            mem = res / 10;
            ListNode listNode = new ListNode(res % 10);
            l3.next = listNode;
            l3 = l3.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (mem > 0) {
            ListNode listNode1 = new ListNode(mem);
            l3.next = listNode1;
        }
        return hook.next;
    }
}
