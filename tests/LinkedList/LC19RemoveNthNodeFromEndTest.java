package tests.LinkedList;

import DS.LinkedLists.LC19RemoveNthNodeFromEnd;
import tests.TestSupport;

/** Tests for {@link LC19RemoveNthNodeFromEnd} (LeetCode 19). */
public class LC19RemoveNthNodeFromEndTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LC19 Remove Nth Node From End");
        LC19RemoveNthNodeFromEnd s = new LC19RemoveNthNodeFromEnd();

        t.checkEquals("[1,2,3,4,5], n=2 -> [1,2,3,5]", new int[]{1, 2, 3, 5},
                TestSupport.toArray(s.removeNthFromEnd(TestSupport.buildList(1, 2, 3, 4, 5), 2)));
        t.checkEquals("[1], n=1 -> []", new int[]{},
                TestSupport.toArray(s.removeNthFromEnd(TestSupport.buildList(1), 1)));
        t.checkEquals("[1,2], n=1 -> [1] (remove last)", new int[]{1},
                TestSupport.toArray(s.removeNthFromEnd(TestSupport.buildList(1, 2), 1)));
        t.checkEquals("[1,2], n=2 -> [2] (remove head)", new int[]{2},
                TestSupport.toArray(s.removeNthFromEnd(TestSupport.buildList(1, 2), 2)));
        t.checkEquals("[1,2,3], n=3 -> [2,3] (remove head)", new int[]{2, 3},
                TestSupport.toArray(s.removeNthFromEnd(TestSupport.buildList(1, 2, 3), 3)));

        t.done();
    }
}
