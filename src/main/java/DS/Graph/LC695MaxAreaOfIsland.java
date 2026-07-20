package DS.Graph;

/**
 * LeetCode 695. Max Area of Island.
 *
 * <p>Given an {@code m x n} binary grid of {@code 1}s (land) and {@code 0}s
 * (water), return the area of the largest island. An island is a group of land
 * cells connected horizontally or vertically. The area is the number of land
 * cells in the island. If there is no island, return {@code 0}.
 *
 * @see <a href="https://leetcode.com/problems/max-area-of-island/">Problem 695</a>
 */
public class LC695MaxAreaOfIsland {

    /**
     * Iterates every cell; when an unvisited land cell is found, runs a DFS that
     * sinks (marks as {@code 0}) every reachable land cell while counting them,
     * then keeps the running maximum area.
     *
     * <p>Time: O(m * n) / Space: O(m * n) worst-case recursion stack.
     *
     * @param grid the m x n binary grid
     * @return the area of the largest island, or {@code 0} if none
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, area(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1)
            return 0;
        grid[r][c] = 0;
        return 1
                + area(grid, r + 1, c)
                + area(grid, r - 1, c)
                + area(grid, r, c + 1)
                + area(grid, r, c - 1);
    }
}
