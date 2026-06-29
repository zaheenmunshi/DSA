package tests;

import DS.LinkedLists.CopyListWithRandomPointer;
import DS.LinkedLists.Helper.Node;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/** Tests for {@link CopyListWithRandomPointer} (LeetCode 138). */
public class CopyListWithRandomPointerTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("CopyListWithRandomPointer (LC 138)");
        CopyListWithRandomPointer s = new CopyListWithRandomPointer();

        t.checkEquals("null list copies to null", true, s.copyRandomList(null) == null);

        // Classic example: values [7,13,11,10,1] with random targets by index.
        int[] vals = {7, 13, 11, 10, 1};
        Integer[] randomIdx = {null, 0, 4, 2, 0};
        Node original = buildWithRandom(vals, randomIdx);
        int[] origVals = valsOf(original);
        int[] origRandom = randomIndices(original);

        Node copy = s.copyRandomList(original);
        t.checkEquals("copy preserves values", origVals, valsOf(copy));
        t.checkEquals("copy preserves random structure", origRandom, randomIndices(copy));
        t.checkEquals("copy is a deep copy (distinct nodes)", true, isDeepCopy(original, copy));
        t.checkEquals("original values unchanged", origVals, valsOf(original));
        t.checkEquals("original random structure unchanged", origRandom, randomIndices(original));

        // Single node whose random points to itself.
        Node single = buildWithRandom(new int[]{1}, new Integer[]{0});
        Node singleCopy = s.copyRandomList(single);
        t.checkEquals("single node value", new int[]{1}, valsOf(singleCopy));
        t.checkEquals("single node self-random preserved", new int[]{0}, randomIndices(singleCopy));
        t.checkEquals("single node deep copy", true, isDeepCopy(single, singleCopy));

        t.done();
    }

    /** Builds a list and wires each node's random pointer to the node at the given index. */
    private static Node buildWithRandom(int[] vals, Integer[] randomIdx) {
        int n = vals.length;
        if (n == 0) {
            return null;
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(vals[i]);
        }
        for (int i = 0; i < n; i++) {
            nodes[i].next = (i + 1 < n) ? nodes[i + 1] : null;
            nodes[i].random = (randomIdx[i] == null) ? null : nodes[randomIdx[i]];
        }
        return nodes[0];
    }

    private static List<Node> nodesOf(Node head) {
        List<Node> list = new ArrayList<>();
        for (Node c = head; c != null; c = c.next) {
            list.add(c);
        }
        return list;
    }

    private static int[] valsOf(Node head) {
        List<Node> ns = nodesOf(head);
        int[] out = new int[ns.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = ns.get(i).val;
        }
        return out;
    }

    /**
     * For each node, the index of its random target within the same list, or
     * {@code -1} when {@code random} is null and {@code -2} when it points to a
     * node outside this list (which would indicate a broken/shallow copy).
     */
    private static int[] randomIndices(Node head) {
        List<Node> ns = nodesOf(head);
        Map<Node, Integer> idx = new IdentityHashMap<>();
        for (int i = 0; i < ns.size(); i++) {
            idx.put(ns.get(i), i);
        }
        int[] out = new int[ns.size()];
        for (int i = 0; i < ns.size(); i++) {
            Node r = ns.get(i).random;
            out[i] = (r == null) ? -1 : idx.getOrDefault(r, -2);
        }
        return out;
    }

    /** Walks both lists in lockstep; every aligned node (and random target) must be a distinct object. */
    private static boolean isDeepCopy(Node original, Node copy) {
        Node a = original;
        Node b = copy;
        while (a != null && b != null) {
            if (a == b) {
                return false; // shared node along the next chain
            }
            if (a.random != null && a.random == b.random) {
                return false; // shared random target
            }
            a = a.next;
            b = b.next;
        }
        return a == null && b == null; // identical length
    }
}