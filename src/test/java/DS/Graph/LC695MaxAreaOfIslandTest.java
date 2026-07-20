package DS.Graph;

import DS.Graph.LC695MaxAreaOfIsland;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC695MaxAreaOfIslandTest {

    private LC695MaxAreaOfIsland s;

    @BeforeEach
    void setUp() { s = new LC695MaxAreaOfIsland(); }

    @Test void nullGrid()  { assertEquals(0, s.maxAreaOfIsland(null)); }
    @Test void emptyGrid() { assertEquals(0, s.maxAreaOfIsland(new int[][]{})); }

    @Test void allWater() {
        assertEquals(0, s.maxAreaOfIsland(new int[][]{
            {0, 0, 0},
            {0, 0, 0}
        }));
    }

    @Test void allLand() {
        assertEquals(6, s.maxAreaOfIsland(new int[][]{
            {1, 1, 1},
            {1, 1, 1}
        }));
    }

    // LeetCode example 1 -> largest island has area 6
    @Test void exampleOne() {
        assertEquals(6, s.maxAreaOfIsland(new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }

    // LeetCode example 2 -> no land, area 0
    @Test void exampleTwo() {
        assertEquals(0, s.maxAreaOfIsland(new int[][]{
            {0,0,0,0,0,0,0,0}
        }));
    }

    @Test void singleLandCell()  { assertEquals(1, s.maxAreaOfIsland(new int[][]{{1}})); }
    @Test void singleWaterCell() { assertEquals(0, s.maxAreaOfIsland(new int[][]{{0}})); }

    // Two separate islands: sizes 3 and 1 -> max is 3
    @Test void multipleIslandsReturnsLargest() {
        assertEquals(3, s.maxAreaOfIsland(new int[][]{
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 0, 0, 0}
        }));
    }

    // Diagonal cells are NOT connected — each is its own island of area 1
    @Test void diagonalCellsAreSeparate() {
        assertEquals(1, s.maxAreaOfIsland(new int[][]{
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1}
        }));
    }
}
