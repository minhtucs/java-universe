package juniverse.algorithm.graph;

import juniverse.algorithm.graph.Graph.Node;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author tunm2
 */
public class StackBasedDFSearcher {
    
    void dfs(Graph g) {
        boolean[] visited = new boolean[g.nVertices];
        for (int v = 0; v < g.nVertices; v++)
            visited[v] = false;
        
        for (int v = 0; v < g.nVertices; v++)
            if (!visited[v])
                dfs(g, v, visited);
    }
    
    void dfs(Graph g, int vRoot, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vRoot);
        visited[vRoot] = true;
        
        while (!stack.isEmpty()) {
            Integer v = stack.pop();
            processVertex(v);
            Set<Node> neibors = g.neibors(v);
            for (Node neibor : neibors) {
                int vNeibor = neibor.vertex;
                if (!visited[vNeibor]) {
                    stack.push(vNeibor);
                    visited[vNeibor] = true;
                }
            }
        }
    }
    
    void processVertex(int v) {
        System.out.print(v + " ");
    }
}
