package DS.LinkedList;

import DS.LinkedLists.LC138CopyListWithRandomPointer;
import DS.LinkedLists.Helper.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LC138CopyListWithRandomPointerTest {

    private LC138CopyListWithRandomPointer s;

    @BeforeEach
    void setUp() { s = new LC138CopyListWithRandomPointer(); }

    @Test void nullInput() { assertNull(s.copyRandomList(null)); }

    @Test void singleNodeSelfRandom() {
        Node n = new Node(1);
        n.random = n;
        Node copy = s.copyRandomList(n);
        assertEquals(1, copy.val);
        assertNotSame(n, copy);
        assertSame(copy, copy.random);
    }

    @Test void fiveNodeList() {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node a = new Node(7), b = new Node(13), c = new Node(11),
             d = new Node(10), e = new Node(1);
        a.next = b; b.next = c; c.next = d; d.next = e;
        a.random = null; b.random = a; c.random = e;
        d.random = c;   e.random = a;

        Node h = s.copyRandomList(a);

        // vals
        assertEquals(7,  h.val);
        assertEquals(13, h.next.val);
        assertEquals(11, h.next.next.val);
        assertEquals(10, h.next.next.next.val);
        assertEquals(1,  h.next.next.next.next.val);

        // independence
        assertNotSame(a, h);

        // random pointers
        assertNull(h.random);
        assertEquals(7,  h.next.random.val);
        assertEquals(1,  h.next.next.random.val);
        assertEquals(11, h.next.next.next.random.val);
        assertEquals(7,  h.next.next.next.next.random.val);

        // randoms point into the copy, not the original
        assertNotSame(a, h.next.random);
    }
}
