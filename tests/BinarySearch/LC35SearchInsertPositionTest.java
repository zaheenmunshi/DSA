package tests.BinarySearch;

import DS.BinarySearch.LC35SearchInsertPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LC35SearchInsertPositionTest {

    private LC35SearchInsertPosition s;
    private int[] nums;

    @BeforeEach
    void setUp() {
        s = new LC35SearchInsertPosition();
        nums = new int[]{1, 3, 5, 6};
    }

    @Test void targetPresent()       { assertEquals(2, s.searchInsert(nums, 5)); }
    @Test void insertInMiddle()      { assertEquals(1, s.searchInsert(nums, 2)); }
    @Test void insertAtFront()       { assertEquals(0, s.searchInsert(nums, 0)); }
    @Test void insertAtEnd()         { assertEquals(4, s.searchInsert(nums, 7)); }
    @Test void targetAtFirstIndex()  { assertEquals(0, s.searchInsert(nums, 1)); }
    @Test void targetAtLastIndex()   { assertEquals(3, s.searchInsert(nums, 6)); }
    @Test void emptyArray()          { assertEquals(0, s.searchInsert(new int[]{}, 5)); }
}
