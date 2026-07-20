package DS.Graph;

import DS.Graph.LC200NumberOfIslands;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC200NumberOfIslandsTest {

    private LC200NumberOfIslands s;

    @BeforeEach
    void setUp() { s = new LC200NumberOfIslands(); }

    @Test void nullGrid()    { assertEquals(0, s.numIslands(null)); }
    @Test void emptyGrid()   { assertEquals(0, s.numIslands(new char[][]{})); }

    @Test void allWater() {
        assertEquals(0, s.numIslands(new char[][]{
            {'0','0','0'},
            {'0','0','0'}
        }));
    }

    @Test void allLand() {
        assertEquals(1, s.numIslands(new char[][]{
            {'1','1','1'},
            {'1','1','1'}
        }));
    }

    @Test void exampleOne() {
        assertEquals(1, s.numIslands(new char[][]{
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        }));
    }

    @Test void exampleTwo() {
        assertEquals(3, s.numIslands(new char[][]{
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        }));
    }

    @Test void singleLandCell()  { assertEquals(1, s.numIslands(new char[][]{{'1'}})); }
    @Test void singleWaterCell() { assertEquals(0, s.numIslands(new char[][]{{'0'}})); }

    @Test void diagonalCellsAreSeparate() {
        // Diagonals are not connected — 4 corners + 1 centre = 5 islands
        assertEquals(5, s.numIslands(new char[][]{
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        }));
    }
}
