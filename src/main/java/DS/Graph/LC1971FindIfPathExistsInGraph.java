package DS.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 1971. Find if Path Exists in Graph.
 *
 * <p>Given an undirected graph with {@code n} nodes (labelled 0 to n-1) and a
 * list of bidirectional edges, determine whether a valid path exists from
 * {@code source} to {@code destination}.
 *
 * @see <a href="https://leetcode.com/problems/find-if-path-exists-in-graph/">Problem 1971</a>
 */
public class LC1971FindIfPathExistsInGraph {

    /**
     * BFS from {@code source}: enqueue neighbours level by level; return
     * {@code true} as soon as {@code destination} is reached.
     *
     * <p>Time: O(V + E) / Space: O(V + E).
     *
     * @param n           number of nodes
     * @param edges       undirected edges as [u, v] pairs
     * @param source      starting node
     * @param destination target node
     * @return {@code true} if a path from source to destination exists
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (neighbor == destination) return true;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }
}
