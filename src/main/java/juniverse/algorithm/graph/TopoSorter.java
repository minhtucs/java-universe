package juniverse.algorithm.graph;

import juniverse.algorithm.graph.Graph.Node;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author tunm2
 */
public class TopoSorter {
    
    public List<Integer> sort(Graph g) {
        Stack<Integer> topo = new Stack<>();
        boolean[] visited = new boolean[g.nVertices];
        
        for (int v = 0; v < g.nVertices; v++)
            if (!visited[v])
                dfs(g, v, visited, topo);
        
        return topo;
    }
    
    void dfs(Graph g, int v, boolean[] visited, Stack<Integer> topo) {
        visited[v] = true;
        
        Set<Node> neibors = g.neibors(v);
        for (Node neibor : neibors) {
            if (!visited[neibor.vertex])
                dfs(g, neibor.vertex, visited, topo);
        }
        
        topo.push(v);
    }
}
