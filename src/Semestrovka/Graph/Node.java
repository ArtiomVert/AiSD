package Semestrovka.Graph;

import java.util.ArrayList;
import java.util.Comparator;

public class Node {
    public int name;
    public ArrayList<Pair> pairs = new ArrayList<>();
    public Node(int name){
        this.name = name;
    }
    public void addJoin(Node n, int ves){
        pairs.add(new Pair(n, ves));
    }
    public void end(){
        pairs.sort(Comparator.comparingInt(o -> o.ves));
    }
}
