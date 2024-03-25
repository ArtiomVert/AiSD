package Semestrovka;

import Semestrovka.BinTree.BinTree;
import Semestrovka.Graph.Graph;
import Semestrovka.Graph.Node;
import Semestrovka.Graph.Pair;

import java.util.ArrayList;
import java.util.List;

public class MinWay {

    static int getMinWay1(int[][] graph) {
        int min_way = 0;
        List<Integer> top_ost = new ArrayList<>();
        List<Integer> other_top = new ArrayList<>();
        top_ost.add(0);
        for (int i = 1; i < graph.length; i++) {
            other_top.add(i);
        }
        while (!other_top.isEmpty()) {
            int min_edge = -1;
            int cur_top = -1;
            for (int t1 : top_ost) {
                for (int t2 : other_top) {
                    if (graph[t1][t2] == 0) continue;
                    if ((min_edge > graph[t1][t2]) || (cur_top == -1)) {
                        cur_top = t2;
                        min_edge = graph[t1][t2];
                    }
                }
            }
            min_way += min_edge;
            top_ost.add(cur_top);
            other_top.remove(new Integer(cur_top));
        }
        return min_way;
    }

    static int getMinWay2(Graph g) {
        int min_way = 0;
        BinTree ready = new BinTree();
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(g.nodes[g.n / 2]);
        ready.push(g.n / 2);
        while (nodes.size() != g.n) {
            Pair pair = new Pair(null, Integer.MAX_VALUE);
            for (Node node : nodes) {
                for (Pair p : node.pairs) {
                    if (ready.serch(p.node.name)) continue;
                    if (pair.ves > p.ves) pair = p;
                    break;
                }
            }
            ready.push(pair.node.name);
            nodes.add(pair.node);
            min_way += pair.ves;
        }
        return min_way;
    }
}
