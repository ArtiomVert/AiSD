package Semestrovka.Graph;

import java.util.ArrayList;

public class Node {
    int name;
    int cj = 0;
    Node[] joins;
    ArrayList<Node> joins_1 = new ArrayList<>();
    int[] ves_edge;
    ArrayList<Integer> ves_edge_1 = new ArrayList<>();
    public Node(int name){
        this.name = name;
    }
    public void addJoin(Node n, int ves){
        joins_1.add(n);
        ves_edge_1.add(ves);
        cj++;
    }
    public void end(){
        joins = new Node[cj];
        ves_edge = new int[cj];
        int f = 0;
        for (Integer i: ves_edge_1){
            ves_edge[f] = i;
            f++;
        }
        f = 0;
        for (Node i: joins_1){
            joins[f] = i;
            f++;
        }
    }
}
