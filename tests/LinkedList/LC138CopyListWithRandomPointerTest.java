package tests.LinkedList;

import DS.LinkedLists.LC138CopyListWithRandomPointer;
import DS.LinkedLists.Helper.Node;
import tests.TestSupport;

/** Tests for {@link LC138CopyListWithRandomPointer} (LeetCode 138). */
public class LC138CopyListWithRandomPointerTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC138 Copy List with Random Pointer");
        LC138CopyListWithRandomPointer s = new LC138CopyListWithRandomPointer();

        t.checkEquals("null input -> null", true, s.copyRandomList(null) == null);

        // Single node, random points to itself
        Node n1 = new Node(1);
        n1.random = n1;
        Node copy1 = s.copyRandomList(n1);
        t.checkEquals("single node: val copied", 1, copy1.val);
        t.checkEquals("single node: is a new object", true, copy1 != n1);
        t.checkEquals("single node: random points to itself", true, copy1.random == copy1);

        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b; b.next = c; c.next = d; d.next = e;
        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        Node copyHead = s.copyRandomList(a);

        // Verify vals
        t.checkEquals("5-node list: val[0]", 7,  copyHead.val);
        t.checkEquals("5-node list: val[1]", 13, copyHead.next.val);
        t.checkEquals("5-node list: val[2]", 11, copyHead.next.next.val);
        t.checkEquals("5-node list: val[3]", 10, copyHead.next.next.next.val);
        t.checkEquals("5-node list: val[4]", 1,  copyHead.next.next.next.next.val);

        // Verify no original nodes reused
        t.checkEquals("copy is independent of original", true, copyHead != a);

        // Verify random pointers
        t.checkEquals("random[0] is null", true, copyHead.random == null);
        t.checkEquals("random[1] -> node[0]", 7, copyHead.next.random.val);
        t.checkEquals("random[2] -> node[4]", 1, copyHead.next.next.random.val);
        t.checkEquals("random[3] -> node[2]", 11, copyHead.next.next.next.random.val);
        t.checkEquals("random[4] -> node[0]", 7, copyHead.next.next.next.next.random.val);

        // Verify randoms point into the copy, not the original
        t.checkEquals("random[1] is in copy list, not original", true,
                copyHead.next.random != a);

        t.done();
    }
}
