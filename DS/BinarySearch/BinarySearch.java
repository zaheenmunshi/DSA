package DS.BinarySearch;

/**
 * LeetCode 704. Binary Search.
 *
 * <p>Given an array of integers {@code nums} sorted in ascending order and an
 * integer {@code target}, return the index of {@code target} if it is present,
 * or {@code -1} if it is not.
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">Problem 704</a>
 */
public class BinarySearch {

    /**
     * Searches for {@code target} using classic binary search: maintain a
     * {@code [left, right]} window and halve it each iteration by comparing
     * {@code target} against the midpoint.
     *
     * <p>Time: O(log n) / Space: O(1).
     *
     * @param nums   a sorted array of distinct integers
     * @param target the value to search for
     * @return the index of {@code target}, or {@code -1} if not found
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}