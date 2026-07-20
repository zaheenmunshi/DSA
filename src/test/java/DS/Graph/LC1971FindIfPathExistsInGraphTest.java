package DS.Graph;

import DS.Graph.LC1971FindIfPathExistsInGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LC1971FindIfPathExistsInGraphTest {

    private LC1971FindIfPathExistsInGraph s;

    @BeforeEach
    void setUp() { s = new LC1971FindIfPathExistsInGraph(); }

    @Test void sourceEqualsDestination() {
        assertTrue(s.validPath(1, new int[][]{}, 0, 0));
    }

    @Test void connectedTriangle() {
        assertTrue(s.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }

    @Test void disconnectedGraph() {
        assertFalse(s.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

    @Test void directEdge() {
        assertTrue(s.validPath(2, new int[][]{{0,1}}, 0, 1));
    }

    @Test void noEdgesDifferentNodes() {
        assertFalse(s.validPath(3, new int[][]{}, 0, 2));
    }

    @Test void linearChainReachable() {
        assertTrue(s.validPath(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}, 0, 4));
    }

    @Test void brokenChainUnreachable() {
        assertFalse(s.validPath(4, new int[][]{{0,1},{2,3}}, 0, 3));
    }
}
