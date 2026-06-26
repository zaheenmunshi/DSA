package DS.LinkedLists;

import DS.LinkedLists.Helper.ListNode;

/**
 * LeetCode 141. Linked List Cycle.
 *
 * <p>Given the head of a linked list, determine whether the list contains a
 * cycle (some node can be reached again by continuously following {@code next}).
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">Problem 141</a>
 */
public class LinkedListCycle {
    /**
     * Detects a cycle using Floyd's tortoise-and-hare algorithm: a slow pointer
     * advances one node at a time and a fast pointer two; if they ever meet, the
     * list has a cycle, otherwise the fast pointer reaches the end.
     *
     * <p>Time: O(n) / Space: O(1).
     *
     * @param head the head of the linked list (may be {@code null})
     * @return {@code true} if the list contains a cycle, {@code false} otherwise
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return false;

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
