package DS.LinkedLists;

import DS.LinkedLists.Helper.ListNode;

//Leet Code 876. Middle of the Linked List
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
