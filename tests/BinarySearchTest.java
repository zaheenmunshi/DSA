package tests;

import DS.BinarySearch.BinarySearch;

/** Tests for {@link BinarySearch} (LeetCode 704). */
public class BinarySearchTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("BinarySearch (LC 704)");
        BinarySearch s = new BinarySearch();

        int[] nums = {-1, 0, 3, 5, 9, 12};
        t.checkEquals("target present (middle)", 4, s.search(nums, 9));
        t.checkEquals("target at first index", 0, s.search(nums, -1));
        t.checkEquals("target at last index", 5, s.search(nums, 12));
        t.checkEquals("target absent (too small)", -1, s.search(nums, -5));
        t.checkEquals("target absent (too large)", -1, s.search(nums, 20));
        t.checkEquals("target absent (within range)", -1, s.search(nums, 2));
        t.checkEquals("single element found", 0, s.search(new int[]{5}, 5));
        t.checkEquals("single element not found", -1, s.search(new int[]{5}, 3));
        t.checkEquals("empty array", -1, s.search(new int[]{}, 1));

        t.done();
    }
}