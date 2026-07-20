package tests.Graph;

import DS.Graph.LC200NumberOfIslands;
import tests.TestSupport;

/** Tests for {@link LC200NumberOfIslands} (LeetCode 200). */
public class LC200NumberOfIslandsTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC200 Number of Islands");
        LC200NumberOfIslands s = new LC200NumberOfIslands();

        t.checkEquals("null grid", 0, s.numIslands(null));
        t.checkEquals("empty grid", 0, s.numIslands(new char[][]{}));

        t.checkEquals("all water", 0, s.numIslands(new char[][]{
            {'0','0','0'},
            {'0','0','0'}
        }));

        t.checkEquals("all land = 1 island", 1, s.numIslands(new char[][]{
            {'1','1','1'},
            {'1','1','1'}
        }));

        // LeetCode example 1 -> 1
        t.checkEquals("example 1: one large island", 1, s.numIslands(new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        }));

        // LeetCode example 2 -> 3
        t.checkEquals("example 2: three islands", 3, s.numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        }));

        t.checkEquals("single land cell", 1, s.numIslands(new char[][]{{'1'}}));
        t.checkEquals("single water cell", 0, s.numIslands(new char[][]{{'0'}}));

        // Diagonal cells are NOT connected — 4 corners + 1 centre = 5 islands
        t.checkEquals("diagonal cells are separate islands", 5, s.numIslands(new char[][]{
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        }));

        t.done();
    }
}
