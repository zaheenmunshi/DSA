package tests.LinkedList;

import DS.LinkedLists.LC141LinkedListCycle;
import DS.LinkedLists.Helper.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LC141LinkedListCycleTest {

    private LC141LinkedListCycle s;

    @BeforeEach
    void setUp() { s = new LC141LinkedListCycle(); }

    @Test void emptyList()              { assertFalse(s.hasCycle(null)); }
    @Test void singleNodeNoCycle()      { assertFalse(s.hasCycle(build(1))); }
    @Test void singleNodeSelfCycle()    { assertTrue(s.hasCycle(buildCycle(new int[]{1}, 0))); }
    @Test void twoNodesNoCycle()        { assertFalse(s.hasCycle(build(1, 2))); }
    @Test void twoNodesCycleToHead()    { assertTrue(s.hasCycle(buildCycle(new int[]{1, 2}, 0))); }
    @Test void longerListNoCycle()      { assertFalse(s.hasCycle(build(1, 2, 3, 4, 5))); }
    @Test void longerListCycleMiddle()  { assertTrue(s.hasCycle(buildCycle(new int[]{3, 2, 0, -4}, 1))); }

    // ---- helpers ----

    private static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) { tail.next = new ListNode(v); tail = tail.next; }
        return dummy.next;
    }

    private static ListNode buildCycle(int[] vals, int pos) {
        ListNode dummy = new ListNode(0), tail = dummy, target = null;
        for (int i = 0; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]); tail = tail.next;
            if (i == pos) target = tail;
        }
        tail.next = target;
        return dummy.next;
    }
}
