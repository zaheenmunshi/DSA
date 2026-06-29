package tests;

import DS.LinkedLists.LinkedListCycle;

/** Tests for {@link LinkedListCycle} (LeetCode 141). */
public class LinkedListCycleTest {
    public static void main(String[] args) {
        TestSupport t = new TestSupport("LinkedListCycle (LC 141)");
        LinkedListCycle s = new LinkedListCycle();

        t.checkEquals("empty list", false, s.hasCycle(null));
        t.checkEquals("single node, no cycle", false, s.hasCycle(TestSupport.buildList(1)));
        t.checkEquals("single node, self cycle", true,
                s.hasCycle(TestSupport.buildListWithCycle(new int[]{1}, 0)));
        t.checkEquals("two nodes, no cycle", false, s.hasCycle(TestSupport.buildList(1, 2)));
        t.checkEquals("two nodes, cycle to head", true,
                s.hasCycle(TestSupport.buildListWithCycle(new int[]{1, 2}, 0)));
        t.checkEquals("longer list, no cycle", false,
                s.hasCycle(TestSupport.buildList(1, 2, 3, 4, 5)));
        t.checkEquals("longer list, cycle in middle [3,2,0,-4] pos=1", true,
                s.hasCycle(TestSupport.buildListWithCycle(new int[]{3, 2, 0, -4}, 1)));

        t.done();
    }
}