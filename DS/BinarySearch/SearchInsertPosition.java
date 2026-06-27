package DS.BinarySearch;

/**
 * LeetCode 35. Search Insert Position.
 *
 * <p>Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be
 * inserted to keep the array sorted.
 *
 * @see <a href="https://leetcode.com/problems/search-insert-position/">Problem 35</a>
 */
public class SearchInsertPosition {

    /**
     * Uses binary search to locate {@code target}. When the loop exits without
     * a match, {@code left} is exactly the insertion index — the first position
     * whose value is greater than {@code target}.
     *
     * <p>Time: O(log n) / Space: O(1).
     *
     * @param nums   a sorted array of distinct integers
     * @param target the value to search for or insert
     * @return the index of {@code target} if present, otherwise its insertion index
     */
    public int searchInsert(int[] nums, int target) {

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
        return left;
    }
}