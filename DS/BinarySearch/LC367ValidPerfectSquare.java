package DS.BinarySearch;

/**
 * LeetCode 367. Valid Perfect Square.
 *
 * <p>Given a positive integer {@code num}, return {@code true} if it is a
 * perfect square (i.e. the square of some integer), without using any
 * built-in square-root function.
 *
 * @see <a href="https://leetcode.com/problems/valid-perfect-square/">Problem 367</a>
 */
public class LC367ValidPerfectSquare {

    /**
     * Binary-searches the range {@code [1, num/2]} for an integer whose square
     * equals {@code num}. The intermediate product is cast to {@code long} to
     * prevent overflow for large inputs.
     *
     * <p>Time: O(log n) / Space: O(1).
     *
     * @param num a positive integer
     * @return {@code true} if {@code num} is a perfect square, {@code false} otherwise
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;

        int left = 0;
        int right = num / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square <= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
