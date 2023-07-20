package easy;

import util.ListNode;

public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode oldlist1 = list1;
        ListNode oldlist2 = list2;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode preCoppy = new ListNode(-1);
        ListNode coppy = new ListNode();
        preCoppy.next = coppy;

        while (list1 != null && list2 != null){

            if(list1.val <= list2.val) {
                ListNode insert = list1;
                list1 = list1.next;
                insert.next = null;
                coppy.next = insert;
            } else {
                ListNode insert = list2;
                list2 = list2.next;
                insert.next = null;
                coppy.next = insert;
            }
            coppy = coppy.next;
            if (list1 == null)
                coppy.next = list2;

            if (list2 == null)
                coppy.next = list1;

        }

        return preCoppy.next.next;
    }
}
