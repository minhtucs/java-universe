package juniverse.algorithm.graph;

import juniverse.algorithm.graph.Graph.Node;
import java.util.Set;

/**
 *
 * @author tunm2
 */
public class RecursionDFSearcher {
    
    void dfs(Graph g) {
        boolean[] visited = new boolean[g.nVertices];
        for (int v = 0; v < g.nVertices; v++)
            visited[v] = false;
        
        for (int v = 0; v < g.nVertices; v++)
            if (!visited[v])
                _dfs(v, g, visited);
    }
    
    void _dfs(int vRoot, Graph g, boolean[] visited) {
        processVertex(vRoot);
        visited[vRoot] = true;
        
        Set<Node> neibors = g.neibors(vRoot);
        for (Node neibor : neibors) {
            if (!visited[neibor.vertex])
                _dfs(neibor.vertex, g, visited);
        }
    }
    
    void processVertex(int v) {
        System.out.print(v + " ");
    }
}
