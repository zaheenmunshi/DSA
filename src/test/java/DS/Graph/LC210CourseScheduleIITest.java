package DS.Graph;

import DS.Graph.LC210CourseScheduleII;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LC210CourseScheduleIITest {

    private LC210CourseScheduleII s;

    @BeforeEach
    void setUp() { s = new LC210CourseScheduleII(); }

    // LeetCode example 1: 2 courses, take 0 then 1
    @Test void exampleOne() {
        int[][] pre = {{1, 0}};
        assertValidOrder(2, pre, s.findOrder(2, pre));
    }

    // LeetCode example 2: 4 courses with a branching dependency
    @Test void exampleTwo() {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        assertValidOrder(4, pre, s.findOrder(4, pre));
    }

    @Test void noPrerequisites() {
        int[][] pre = {};
        int[] order = s.findOrder(3, pre);
        assertValidOrder(3, pre, order);
    }

    @Test void singleCourse() {
        int[] order = s.findOrder(1, new int[][]{});
        assertArrayEquals(new int[]{0}, order);
    }

    @Test void selfLoopReturnsEmpty() {
        assertArrayEquals(new int[0], s.findOrder(1, new int[][]{{0, 0}}));
    }

    // 0 <-> 1 cyclic dependency -> no valid order
    @Test void simpleCycleReturnsEmpty() {
        assertArrayEquals(new int[0], s.findOrder(2, new int[][]{{1, 0}, {0, 1}}));
    }

    // 0 -> 1 -> 2 -> 0 cycle -> no valid order
    @Test void longerCycleReturnsEmpty() {
        assertArrayEquals(new int[0], s.findOrder(3, new int[][]{{1, 0}, {2, 1}, {0, 2}}));
    }

    @Test void linearChain() {
        int[][] pre = {{1, 0}, {2, 1}, {3, 2}};
        assertValidOrder(4, pre, s.findOrder(4, pre));
    }

    /**
     * Asserts the returned ordering contains every course exactly once and that
     * for each prerequisite [a, b], b appears before a.
     */
    private static void assertValidOrder(int numCourses, int[][] prerequisites, int[] order) {
        assertEquals(numCourses, order.length, "order must contain every course");

        Map<Integer, Integer> position = new HashMap<>();
        boolean[] seen = new boolean[numCourses];
        for (int i = 0; i < order.length; i++) {
            assertTrue(order[i] >= 0 && order[i] < numCourses, "course label out of range");
            assertTrue(!seen[order[i]], "course must not appear twice");
            seen[order[i]] = true;
            position.put(order[i], i);
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            assertTrue(position.get(prereq) < position.get(course),
                    "prerequisite " + prereq + " must come before " + course);
        }
    }
}
