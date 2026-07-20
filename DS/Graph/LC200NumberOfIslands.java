package DS.Graph;

/**
 * LeetCode 200. Number of Islands.
 *
 * <p>Given an {@code m x n} grid of {@code '1'}s (land) and {@code '0'}s (water),
 * return the number of islands. An island is surrounded by water and formed by
 * connecting adjacent land cells horizontally or vertically.
 *
 * @see <a href="https://leetcode.com/problems/number-of-islands/">Problem 200</a>
 */
public class LC200NumberOfIslands {

    /**
     * Iterates every cell; when an unvisited land cell is found, increments the
     * island count and runs a DFS that sinks (marks as '0') every cell reachable
     * from it, so it is never counted again.
     *
     * <p>Time: O(m * n) / Space: O(m * n) worst-case recursion stack.
     *
     * @param grid the m x n character grid
     * @return number of distinct islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    private void sink(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1')
            return;
        grid[r][c] = '0';
        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }
}
