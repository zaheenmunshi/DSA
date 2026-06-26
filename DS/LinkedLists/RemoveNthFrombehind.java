package DS.LinkedLists;

import DS.LinkedLists.Helper.ListNode;

/**
 * LeetCode 19. Remove Nth Node From End of List.
 *
 * <p>Given the head of a linked list, remove the n-th node from the end of the
 * list and return its head.
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Problem 19</a>
 */
public class RemoveNthFrombehind {
    /**
     * Removes the n-th node from the end in a single pass using two pointers and
     * a dummy node. The {@code ahead} pointer is advanced {@code n + 1} steps so
     * that a gap of {@code n} nodes separates it from {@code behind}; both then
     * advance together until {@code ahead} falls off the end, leaving
     * {@code behind} just before the node to remove. The dummy node keeps the
     * logic uniform when the head itself is removed.
     *
     * <p>Time: O(n) / Space: O(1).
     *
     * @param head the head of the linked list (may be {@code null})
     * @param n    the 1-based position from the end of the node to remove
     * @return the head of the list after removal
     */
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
