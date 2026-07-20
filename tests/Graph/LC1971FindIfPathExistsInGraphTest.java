package tests.Graph;

import DS.Graph.LC1971FindIfPathExistsInGraph;
import tests.TestSupport;

/** Tests for {@link LC1971FindIfPathExistsInGraph} (LeetCode 1971). */
public class LC1971FindIfPathExistsInGraphTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC1971 Find if Path Exists in Graph");
        LC1971FindIfPathExistsInGraph s = new LC1971FindIfPathExistsInGraph();

        // source == destination shortcut
        t.checkEquals("source equals destination", true,
                s.validPath(1, new int[][]{}, 0, 0));

        // LeetCode example 1: n=3, edges=[[0,1],[1,2],[2,0]], src=0, dst=2 -> true
        t.checkEquals("example 1: connected triangle", true,
                s.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));

        // LeetCode example 2: n=6, edges=[[0,1],[0,2],[3,5],[5,4],[4,3]], src=0, dst=5 -> false
        t.checkEquals("example 2: disconnected graph", false,
                s.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));

        // Direct edge only
        t.checkEquals("direct edge src->dst", true,
                s.validPath(2, new int[][]{{0,1}}, 0, 1));

        // No edges, different nodes
        t.checkEquals("no edges, src != dst", false,
                s.validPath(3, new int[][]{}, 0, 2));

        // Linear chain: 0-1-2-3-4, path from 0 to 4
        t.checkEquals("linear chain 0->4", true,
                s.validPath(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}, 0, 4));

        // Linear chain: 0-1-2, no path from 0 to 2 if edge 1-2 is missing
        t.checkEquals("broken chain, no path", false,
                s.validPath(4, new int[][]{{0,1},{2,3}}, 0, 3));

        t.done();
    }
}
