package DS.LinkedLists.Helper;

/**
 * Standard singly linked list node holding an integer value and a reference to
 * the next node. Shared by the linked-list solutions in this package.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}
