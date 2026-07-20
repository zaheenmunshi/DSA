package DS.Graph;

import DS.Graph.LC133CloneGraph;
import DS.Graph.Helper.GraphNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LC133CloneGraphTest {

    private LC133CloneGraph s;

    @BeforeEach
    void setUp() { s = new LC133CloneGraph(); }

    @Test void nullGraph() {
        assertNull(s.cloneGraph(null));
    }

    @Test void singleNodeNoNeighbors() {
        GraphNode original = new GraphNode(1);
        GraphNode clone = s.cloneGraph(original);

        assertNotSame(original, clone);
        assertEquals(1, clone.val);
        assertTrue(clone.neighbors.isEmpty());
    }

    @Test void singleNodeSelfLoop() {
        GraphNode original = new GraphNode(1);
        original.neighbors.add(original);

        GraphNode clone = s.cloneGraph(original);

        assertNotSame(original, clone);
        assertEquals(1, clone.neighbors.size());
        // self-loop must point to the clone, not the original
        assertSame(clone, clone.neighbors.get(0));
    }

    // LeetCode example: 4-node square graph
    // 1 - 2
    // |   |
    // 4 - 3
    @Test void fourNodeSquare() {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        GraphNode clone = s.cloneGraph(n1);

        assertGraphDeepCopy(n1, clone);
    }

    @Test void twoNodeGraph() {
        GraphNode a = new GraphNode(1);
        GraphNode b = new GraphNode(2);
        a.neighbors.add(b);
        b.neighbors.add(a);

        GraphNode clone = s.cloneGraph(a);

        assertGraphDeepCopy(a, clone);
    }

    /**
     * Walks both graphs in lockstep via BFS, asserting that every reachable node
     * is a distinct object (deep copy), has the same value, and the same
     * neighbour values in the same order.
     */
    private static void assertGraphDeepCopy(GraphNode original, GraphNode clone) {
        assertNotSame(original, clone);

        Queue<GraphNode> origQ = new ArrayDeque<>();
        Queue<GraphNode> cloneQ = new ArrayDeque<>();
        Set<GraphNode> visited = new HashSet<>();

        origQ.add(original);
        cloneQ.add(clone);
        visited.add(original);

        while (!origQ.isEmpty()) {
            GraphNode o = origQ.poll();
            GraphNode c = cloneQ.poll();

            assertNotSame(o, c, "clone must be a distinct object");
            assertEquals(o.val, c.val, "values must match");
            assertEquals(o.neighbors.size(), c.neighbors.size(), "neighbour counts must match");

            for (int i = 0; i < o.neighbors.size(); i++) {
                GraphNode oNext = o.neighbors.get(i);
                GraphNode cNext = c.neighbors.get(i);
                assertNotSame(oNext, cNext, "neighbour clone must be distinct");
                assertEquals(oNext.val, cNext.val, "neighbour values must match");

                if (visited.add(oNext)) {
                    origQ.add(oNext);
                    cloneQ.add(cNext);
                }
            }
        }
    }
}
