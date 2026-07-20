package DS.LinkedLists;

import DS.LinkedLists.Helper.Node;

/**
 * LeetCode 138. Copy List with Random Pointer.
 *
 * <p>Given a linked list where each node carries an additional {@code random}
 * pointer that may point to any node in the list (or {@code null}), build a
 * deep copy. The copy must consist of brand-new nodes whose {@code next} and
 * {@code random} pointers reproduce the structure of the original without
 * referencing any of its nodes.
 *
 * @see <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">Problem 138</a>
 */
public class LC138CopyListWithRandomPointer {

    /**
     * Deep-copies the list in O(1) extra space by interweaving the clones with
     * the originals:
     * <ol>
     *   <li>Insert each cloned node immediately after its original, producing
     *       {@code A -> A' -> B -> B' -> ...}.</li>
     *   <li>Wire up each clone's random pointer: the clone of {@code curr} sits
     *       at {@code curr.next}, and the clone of {@code curr.random} sits at
     *       {@code curr.random.next}, so {@code curr.next.random = curr.random.next}.</li>
     *   <li>Unweave the two lists, restoring the original and returning the copy.</li>
     * </ol>
     *
     * <p>Time: O(n) / Space: O(1) (excluding the returned list).
     *
     * @param head the head of the list to copy (may be {@code null})
     * @return the head of the deep-copied list, or {@code null} if input is empty
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Pass 1: insert a clone right after each original node.
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Pass 2: assign each clone's random pointer.
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Pass 3: split the interleaved list back into original + copy.
        Node dummy = new Node(0);
        Node copyTail = dummy;
        curr = head;
        while (curr != null) {
            copyTail.next = curr.next;
            copyTail = copyTail.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
