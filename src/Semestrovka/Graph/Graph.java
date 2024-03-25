package Semestrovka.Graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public Node[] nodes;
    public int n;

    public Graph(int n) {
        this.n = n;
        this.nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdges(int[][] edges) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j]==0) continue;
                nodes[i].addJoin(nodes[j], edges[i][j]);
            }
        }
        for (Node node:nodes){
            node.end();
        }
    }
}
