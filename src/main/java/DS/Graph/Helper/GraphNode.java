package DS.Graph.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Undirected graph node with a value and a list of neighbours. Used by problems
 * such as <em>Clone Graph</em> (LeetCode 133).
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
