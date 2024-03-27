package Semestrovka;

import Semestrovka.BinTree.BinTree;
import Semestrovka.Graph.Graph;
import Semestrovka.Graph.Node;
import Semestrovka.Graph.Pair;

import java.util.ArrayList;
import java.util.List;

public class MinWay {

    static long getMinWay1(int[][] graph) {
        long iter = 0;
        int min_way = 0;
        List<Integer> top_ost = new ArrayList<>();
        List<Integer> other_top = new ArrayList<>();
        top_ost.add(0);
        for (int i = 1; i < graph.length; i++) {
            other_top.add(i);
            iter++;
        }
        while (!other_top.isEmpty()) {
            int min_edge = -1;
            int cur_top = -1;
            for (int t1 : top_ost) {
                for (int t2 : other_top) {
                    if (graph[t1][t2] == 0) {
                        iter++;
                        continue;
                    }
                    if ((min_edge > graph[t1][t2]) || (cur_top == -1)) {
                        cur_top = t2;
                        min_edge = graph[t1][t2];
                    }
                    iter++;
                }
            }
            min_way += min_edge;
            top_ost.add(cur_top);
            other_top.remove(new Integer(cur_top));
        }
        //return min_way;
        return iter;
    }

    static long getMinWay2(int[][] graph) {
        long iter = 0;
        int min_way = 0;
        int n = graph.length;
        Node fnode = new Graph(n).addEdges(graph).nodes[n / 2];
        BinTree ready = new BinTree();
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(fnode);
        ready.push(n / 2);
        while (nodes.size() != n) {
            Pair pair = new Pair(null, Integer.MAX_VALUE);
            for (Node node : nodes) {
                for (Pair p : node.pairs) {
                    if (ready.serch(p.node.name)) {
                        iter++;
                        continue;
                    }
                    if (pair.ves > p.ves) pair = p;
                    iter++;
                    break;
                }
            }
            ready.push(pair.node.name);
            nodes.add(pair.node);
            min_way += pair.ves;
        }
        //return min_way;
        return iter;
    }
}
