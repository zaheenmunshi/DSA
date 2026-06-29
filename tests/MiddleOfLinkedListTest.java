package tests;

import DS.LinkedLists.MiddleOfLinkedList;

/** Tests for {@link MiddleOfLinkedList} (LeetCode 876). */
public class MiddleOfLinkedListTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("MiddleOfLinkedList (LC 876)");
        MiddleOfLinkedList s = new MiddleOfLinkedList();

        t.checkEquals("empty list returns null", true, s.middleNode(null) == null);
        t.checkEquals("single node", 1, s.middleNode(TestSupport.buildList(1)).val);
        t.checkEquals("odd length [1,2,3] -> 2", 2,
                s.middleNode(TestSupport.buildList(1, 2, 3)).val);
        t.checkEquals("even length [1,2,3,4] -> 3 (second middle)", 3,
                s.middleNode(TestSupport.buildList(1, 2, 3, 4)).val);
        t.checkEquals("odd length [1..5] -> 3", 3,
                s.middleNode(TestSupport.buildList(1, 2, 3, 4, 5)).val);
        t.checkEquals("even length [1..6] -> 4 (second middle)", 4,
                s.middleNode(TestSupport.buildList(1, 2, 3, 4, 5, 6)).val);

        t.done();
    }
}