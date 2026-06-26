package DS.LinkedLists.Helper;

/**
 * Singly linked list node with an extra {@code random} pointer that can point to
 * any node in the list (or {@code null}). Used by problems such as
 * <em>Copy List with Random Pointer</em> (LeetCode 138).
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
