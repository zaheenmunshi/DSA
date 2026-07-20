package DS.Graph;

import DS.Graph.LC207CourseSchedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LC207CourseScheduleTest {

    private LC207CourseSchedule s;

    @BeforeEach
    void setUp() { s = new LC207CourseSchedule(); }

    // LeetCode example 1: 2 courses, take 0 then 1 -> possible
    @Test void exampleOnePossible() {
        assertTrue(s.canFinish(2, new int[][]{{1, 0}}));
    }

    // LeetCode example 2: 0<->1 cyclic dependency -> impossible
    @Test void exampleTwoCycle() {
        assertFalse(s.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test void noPrerequisites() {
        assertTrue(s.canFinish(3, new int[][]{}));
    }

    @Test void singleCourse() {
        assertTrue(s.canFinish(1, new int[][]{}));
    }

    @Test void selfLoopImpossible() {
        assertFalse(s.canFinish(1, new int[][]{{0, 0}}));
    }

    // Linear chain 0 -> 1 -> 2 -> 3 (each depends on the previous) -> possible
    @Test void linearChainPossible() {
        assertTrue(s.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));
    }

    // Longer cycle 0 -> 1 -> 2 -> 0 -> impossible
    @Test void longerCycleImpossible() {
        assertFalse(s.canFinish(3, new int[][]{{1, 0}, {2, 1}, {0, 2}}));
    }

    // Diamond dependency (no cycle) -> possible
    @Test void diamondPossible() {
        assertTrue(s.canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

    // Multiple independent components, one containing a cycle -> impossible
    @Test void cycleInOneComponentImpossible() {
        assertFalse(s.canFinish(5, new int[][]{{1, 0}, {3, 4}, {4, 3}}));
    }
}
