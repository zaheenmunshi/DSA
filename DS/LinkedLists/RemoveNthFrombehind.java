package DS.LinkedLists;

import DS.LinkedLists.Helper.ListNode;

//Leet Code 19. Remove Nth Node From End of List
public class RemoveNthFrombehind {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ahead = dummy;
        ListNode behind = dummy;

        for (int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while (ahead != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }
}
