package DS.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 210. Course Schedule II.
 *
 * <p>There are {@code numCourses} courses labelled {@code 0} to
 * {@code numCourses - 1}. {@code prerequisites[i] = [a, b]} means you must take
 * course {@code b} before course {@code a}. Return an ordering of courses you
 * can take to finish all of them. If it is impossible (the prerequisite graph
 * has a cycle), return an empty array. Any valid ordering is accepted.
 *
 * @see <a href="https://leetcode.com/problems/course-schedule-ii/">Problem 210</a>
 */
public class LC210CourseScheduleII {

    /**
     * Kahn's algorithm (BFS topological sort): build the directed graph
     * {@code b -> a} with an in-degree count per node, repeatedly remove nodes
     * with in-degree 0 (appending them to the order) and decrement their
     * neighbours. If every node is emitted the order is valid; otherwise a cycle
     * exists and an empty array is returned.
     *
     * <p>Time: O(V + E) / Space: O(V + E).
     *
     * @param numCourses    total number of courses
     * @param prerequisites pairs {@code [a, b]} meaning b must precede a
     * @return a valid course ordering, or an empty array if none exists
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;
            for (int next : adj.get(course)) {
                if (--inDegree[next] == 0) queue.add(next);
            }
        }

        // If not all courses were emitted, a cycle blocked completion.
        return idx == numCourses ? order : new int[0];
    }
}
