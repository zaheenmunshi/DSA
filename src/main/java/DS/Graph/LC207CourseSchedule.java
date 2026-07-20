package DS.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207. Course Schedule.
 *
 * <p>There are {@code numCourses} courses labelled {@code 0} to
 * {@code numCourses - 1}. {@code prerequisites[i] = [a, b]} means you must take
 * course {@code b} before course {@code a}. Return {@code true} if you can
 * finish all courses, i.e. the prerequisite graph has no cycle.
 *
 * @see <a href="https://leetcode.com/problems/course-schedule/">Problem 207</a>
 */
public class LC207CourseSchedule {

    /**
     * Kahn's algorithm (BFS topological sort): build the directed graph
     * {@code b -> a} with an in-degree count per node, repeatedly remove nodes
     * with in-degree 0, and decrement their neighbours. If every node is removed
     * the graph is acyclic and all courses can be finished; if some remain, a
     * cycle exists.
     *
     * <p>Time: O(V + E) / Space: O(V + E).
     *
     * @param numCourses    total number of courses
     * @param prerequisites pairs {@code [a, b]} meaning b must precede a
     * @return {@code true} if all courses can be completed, {@code false} otherwise
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            for (int next : adj.get(course)) {
                if (--inDegree[next] == 0) queue.add(next);
            }
        }

        return finished == numCourses;
    }
}
