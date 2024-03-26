package Semestrovka.Graph;

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

    public Graph addEdges(int[][] edges) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (edges[i][j]==0) continue;
                nodes[i].addJoin(nodes[j], edges[i][j]);
                nodes[j].addJoin(nodes[i], edges[j][i]);
            }
        }
        for (Node node:nodes){
            node.end();
        }
        return this;
    }
}
