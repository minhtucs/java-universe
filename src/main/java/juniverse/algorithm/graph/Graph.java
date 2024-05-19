package juniverse.algorithm.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tunm2
 */
public class Graph {
    
    public int nVertices;
    public int nEdges;
    public Set<Node>[] adj;
    public boolean directed;
    
    public static Graph readFromFile(String fileName) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufReader = new BufferedReader(reader);
        
        Graph g = new Graph();
        g.nVertices = Integer.parseInt(bufReader.readLine().trim());
        g.nEdges = Integer.parseInt(bufReader.readLine().trim());
        g.adj = new Set[g.nVertices];
        for (int v = 0; v < g.nVertices; v++)
            g.adj[v] = new HashSet<Node>();
        
        String line;
        int vFrom, vTo;
        while ((line = bufReader.readLine()) != null) {
            String[] edgePair = line.split(" ");
            vFrom = Integer.parseInt(edgePair[0].trim());
            vTo = Integer.parseInt(edgePair[1].trim());
            g.addEdge(vFrom, vTo);
        }
        
        return g;
    }
    
    public void addEdge(int vFrom, int vTo) {
        Set<Node> neibors = this.neibors(vFrom);
        Node node = new Node(vTo);
        neibors.add(node);
        if (!directed) {
            Set<Node> neibors2 = this.neibors(vFrom);
            Node node2 = new Node(vTo);
            neibors2.add(node2);
        }
    }
    
    public Set<Node> neibors(int v) {
        return adj[v];
    }
    
    public void print() {
        for (int v = 0; v < nVertices; v++) {
            System.out.print(v + ": ");
            Set<Node> neibors = neibors(v);
            for (Node neibor : neibors)
                System.out.print(neibor + " ");
        }
    }
    
    public static class Node {
        public int vertex;
        // public Object info;
        
        public Node(int vertex) {
            this.vertex = vertex;
        }

        @Override
        public String toString() {
            return String.valueOf(vertex);
        }
    }
}