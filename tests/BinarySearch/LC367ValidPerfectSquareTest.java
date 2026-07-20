package tests.BinarySearch;

import DS.BinarySearch.LC367ValidPerfectSquare;
import tests.TestSupport;

/** Tests for {@link LC367ValidPerfectSquare} (LeetCode 367). */
public class LC367ValidPerfectSquareTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC367 Valid Perfect Square");
        LC367ValidPerfectSquare s = new LC367ValidPerfectSquare();

        t.checkEquals("1 is a perfect square", true, s.isPerfectSquare(1));
        t.checkEquals("4 is a perfect square", true, s.isPerfectSquare(4));
        t.checkEquals("16 is a perfect square", true, s.isPerfectSquare(16));
        t.checkEquals("2 is not", false, s.isPerfectSquare(2));
        t.checkEquals("3 is not", false, s.isPerfectSquare(3));
        t.checkEquals("14 is not", false, s.isPerfectSquare(14));
        t.checkEquals("808201 = 899^2", true, s.isPerfectSquare(808201));
        t.checkEquals("2147395600 = 46340^2 (overflow guard)", true, s.isPerfectSquare(2147395600));
        t.checkEquals("Integer.MAX_VALUE is not", false, s.isPerfectSquare(2147483647));

        t.done();
    }
}
