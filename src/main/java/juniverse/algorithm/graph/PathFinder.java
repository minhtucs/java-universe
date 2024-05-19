package juniverse.algorithm.graph;

import juniverse.algorithm.graph.Graph.Node;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author tunm2
 */
public class PathFinder {
    
    List<Integer> findPath(int vFrom, int vTo, Graph g) {
        int[] parents = new int[g.nVertices];
        bfs(g, vFrom, vTo, parents);
        return getPath(vFrom, vTo, parents);
    }
    
    void bfs(Graph g, int vFrom, int vTo, int[] parents) {
        boolean[] visited = new boolean[g.nVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vFrom);
        visited[vFrom] = true;
        parents[vFrom] = -1;
        
        while (!queue.isEmpty()) {
            Integer v = queue.remove();
            Set<Graph.Node> neibors = g.neibors(v);
            for (Node neibor : neibors) {
                int vNeibor = neibor.vertex;
                if (!visited[vNeibor]) {
                    queue.add(vNeibor);
                    visited[vNeibor] = true;
                    parents[vNeibor] = v;
                    if (vNeibor == vTo)
                        return;
                }
            }
        }
    }
    
    List<Integer> getPath(int vFrom, int vTo, int[] parents) {
        List<Integer> path = new LinkedList<>();
        int v = vTo;
        
        while (parents[v] != -1) {
            path.add(0, v);
            if (parents[v] == vFrom) {
                path.add(0, vFrom);
                return path;
            }
            v = parents[v];
        }
        
        return null;
    }
}
