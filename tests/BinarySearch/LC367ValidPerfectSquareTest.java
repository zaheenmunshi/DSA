package tests.BinarySearch;

import DS.BinarySearch.LC367ValidPerfectSquare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LC367ValidPerfectSquareTest {

    private LC367ValidPerfectSquare s;

    @BeforeEach
    void setUp() { s = new LC367ValidPerfectSquare(); }

    @Test void oneIsPerfectSquare()        { assertTrue(s.isPerfectSquare(1));  }
    @Test void fourIsPerfectSquare()       { assertTrue(s.isPerfectSquare(4));  }
    @Test void sixteenIsPerfectSquare()    { assertTrue(s.isPerfectSquare(16)); }
    @Test void twoIsNot()                  { assertFalse(s.isPerfectSquare(2)); }
    @Test void threeIsNot()                { assertFalse(s.isPerfectSquare(3)); }
    @Test void fourteenIsNot()             { assertFalse(s.isPerfectSquare(14));}
    @Test void largeSquare()               { assertTrue(s.isPerfectSquare(808201));      }
    @Test void overflowGuard()             { assertTrue(s.isPerfectSquare(2147395600));  }
    @Test void intMaxIsNot()               { assertFalse(s.isPerfectSquare(2147483647)); }
}
