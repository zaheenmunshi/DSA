package DS.LinkedList;

import DS.LinkedLists.LC19RemoveNthNodeFromEnd;
import DS.LinkedLists.Helper.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LC19RemoveNthNodeFromEndTest {

    private LC19RemoveNthNodeFromEnd s;

    @BeforeEach
    void setUp() { s = new LC19RemoveNthNodeFromEnd(); }

    @Test void removeSecondFromEnd()  { assertArrayEquals(new int[]{1,2,3,5}, toArr(s.removeNthFromEnd(build(1,2,3,4,5), 2))); }
    @Test void removeSingleNode()     { assertArrayEquals(new int[]{},        toArr(s.removeNthFromEnd(build(1), 1)));          }
    @Test void removeLastNode()       { assertArrayEquals(new int[]{1},       toArr(s.removeNthFromEnd(build(1,2), 1)));        }
    @Test void removeHead()           { assertArrayEquals(new int[]{2},       toArr(s.removeNthFromEnd(build(1,2), 2)));        }
    @Test void removeHeadOfThree()    { assertArrayEquals(new int[]{2,3},     toArr(s.removeNthFromEnd(build(1,2,3), 3)));      }

    private static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int v : vals) { tail.next = new ListNode(v); tail = tail.next; }
        return dummy.next;
    }

    private static int[] toArr(ListNode head) {
        java.util.List<Integer> out = new java.util.ArrayList<>();
        for (ListNode c = head; c != null; c = c.next) out.add(c.val);
        return out.stream().mapToInt(Integer::intValue).toArray();
    }
}
