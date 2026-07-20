package DS.Graph;

import DS.Graph.Helper.GraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 133. Clone Graph.
 *
 * <p>Given a reference to a node in a connected undirected graph, return a deep
 * copy (clone) of the graph. Each node holds a value and a list of its
 * neighbours.
 *
 * @see <a href="https://leetcode.com/problems/clone-graph/">Problem 133</a>
 */
public class LC133CloneGraph {

    /**
     * DFS with a map from original node to its clone. On visiting a node, create
     * its clone (if not already made), then recursively clone each neighbour and
     * link it. The map both memoises clones and breaks cycles in the graph.
     *
     * <p>Time: O(V + E) / Space: O(V).
     *
     * @param node any node of the graph, or {@code null} for an empty graph
     * @return the clone of {@code node}, or {@code null} if input is {@code null}
     */
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> cloned) {
        GraphNode existing = cloned.get(node);
        if (existing != null) return existing;

        GraphNode clone = new GraphNode(node.val);
        cloned.put(node, clone);

        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, cloned));
        }
        return clone;
    }
}
