package tests.BinarySearch;

import DS.BinarySearch.LC35SearchInsertPosition;
import tests.TestSupport;

/** Tests for {@link LC35SearchInsertPosition} (LeetCode 35). */
public class LC35SearchInsertPositionTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC35 Search Insert Position");
        LC35SearchInsertPosition s = new LC35SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        t.checkEquals("target present", 2, s.searchInsert(nums, 5));
        t.checkEquals("insert in middle", 1, s.searchInsert(nums, 2));
        t.checkEquals("insert at front", 0, s.searchInsert(nums, 0));
        t.checkEquals("insert at end", 4, s.searchInsert(nums, 7));
        t.checkEquals("target at first index", 0, s.searchInsert(nums, 1));
        t.checkEquals("target at last index", 3, s.searchInsert(nums, 6));
        t.checkEquals("empty array", 0, s.searchInsert(new int[]{}, 5));

        t.done();
    }
}
