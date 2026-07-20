package DS.LinkedList;

import DS.LinkedLists.LC876MiddleOfLinkedList;
import DS.LinkedLists.Helper.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LC876MiddleOfLinkedListTest {

    private LC876MiddleOfLinkedList s;

    @BeforeEach
    void setUp() { s = new LC876MiddleOfLinkedList(); }

    @Test void emptyList()         { assertNull(s.middleNode(null)); }
    @Test void singleNode()        { assertEquals(1, s.middleNode(build(1)).val); }
    @Test void oddLength()         { assertEquals(2, s.middleNode(build(1, 2, 3)).val); }
    @Test void evenLengthFour()    { assertEquals(3, s.middleNode(build(1, 2, 3, 4)).val); }
    @Test void oddLengthFive()     { assertEquals(3, s.middleNode(build(1, 2, 3, 4, 5)).val); }
    @Test void evenLengthSix()     { assertEquals(4, s.middleNode(build(1, 2, 3, 4, 5, 6)).val); }

    private static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) { tail.next = new ListNode(v); tail = tail.next; }
        return dummy.next;
    }
}
