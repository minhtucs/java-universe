package juniverse.algorithm.graph;

import juniverse.algorithm.graph.Graph.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author tunm2
 */
public class BFSearcher {
    
    void bfs(Graph g, int root) {
        boolean[] visited = new boolean[g.nVertices];
        for (int v = 0; v < g.nVertices; v++)
            visited[v] = false;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        
        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            processVertex(vertex);

            Set<Node> neibors = g.neibors(vertex);
            for (Node neibor : neibors) {
                if (!visited[neibor.vertex]) {
                    queue.add(neibor.vertex);
                    visited[neibor.vertex] = true;
                }
            }
        }
    }
    
    void processVertex(int v) {
        System.out.print(v + " ");
    }   
}