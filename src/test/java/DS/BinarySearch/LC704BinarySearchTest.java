package DS.BinarySearch;

import DS.BinarySearch.LC704BinarySearch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC704BinarySearchTest {

    private LC704BinarySearch s;
    private int[] nums;

    @BeforeEach
    void setUp() {
        s = new LC704BinarySearch();
        nums = new int[]{-1, 0, 3, 5, 9, 12};
    }

    @Test void targetInMiddle()         { assertEquals(4,  s.search(nums, 9));  }
    @Test void targetAtFirstIndex()     { assertEquals(0,  s.search(nums, -1)); }
    @Test void targetAtLastIndex()      { assertEquals(5,  s.search(nums, 12)); }
    @Test void targetAbsentTooSmall()   { assertEquals(-1, s.search(nums, -5)); }
    @Test void targetAbsentTooLarge()   { assertEquals(-1, s.search(nums, 20)); }
    @Test void targetAbsentWithinRange(){ assertEquals(-1, s.search(nums, 2));  }
    @Test void singleElementFound()     { assertEquals(0,  s.search(new int[]{5}, 5));  }
    @Test void singleElementNotFound()  { assertEquals(-1, s.search(new int[]{5}, 3));  }
    @Test void emptyArray()             { assertEquals(-1, s.search(new int[]{}, 1));   }
}
