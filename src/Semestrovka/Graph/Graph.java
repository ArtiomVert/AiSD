package Semestrovka.Graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    Node[] nodes;
    Map<Integer, Integer> accord = new HashMap<>();
    public Graph(int[] names, int[][] edges){
        this.nodes = new Node[names.length];
        for (int i = 0; i < names.length; i++) {
            nodes[i] = new Node(i);
            accord.put(names[i], i);
        }
        for(int[] e:edges){
            nodes[accord.get(e[0])].addJoin(nodes[accord.get(e[1])], e[2]);
            nodes[accord.get(e[1])].addJoin(nodes[accord.get(e[0])], e[2]);
        }
    }
}
