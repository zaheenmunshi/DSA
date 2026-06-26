package DS.LinkedLists;

import DS.LinkedLists.Helper.ListNode;

/**
 * LeetCode 876. Middle of the Linked List.
 *
 * <p>Given the head of a singly linked list, return the middle node. If there
 * are two middle nodes (even length), return the second one.
 *
 * @see <a href="https://leetcode.com/problems/middle-of-the-linked-list/">Problem 876</a>
 */
public class MiddleOfLinkedList {
    /**
     * Finds the middle node with the fast/slow pointer technique: the fast
     * pointer moves two steps per iteration and the slow pointer one, so when
     * fast reaches the end, slow sits at the middle. For an even-length list
     * this returns the second of the two middle nodes.
     *
     * <p>Time: O(n) / Space: O(1).
     *
     * @param head the head of the linked list (may be {@code null})
     * @return the middle node, or {@code null} if the list is empty
     */
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
