package Semestrovka;

import Semestrovka.Graph.Graph;
import Semestrovka.Graph.Node;
import Semestrovka.Graph.Pair;

import java.util.ArrayList;
import java.util.List;

public class MinWay {

    static int getMinWay1(int[][] graph) {//матрица смежности
        int min_way = 0;
        List<Integer> top_ost = new ArrayList<>();//вершины остова
        List<Integer> other_top = new ArrayList<>();//вершины, ещё не вошедшие в остов
        top_ost.add(0);//берём любую вершину
        for (int i = 1; i < graph.length; i++) {
            other_top.add(i);
        }//добавляем оставшиеся
        while (!other_top.isEmpty()) {//пока есть вершины, не вошедшие в остов
            int min_edge = -1;
            int cur_top = -1;//неопределённое минимальное ребро
            for (int t1 : top_ost) {//проходим по всем вершинам остова
                // для каждой вершины проходим по всем "остальным" вершинам
                for (int t2 : other_top) {
                    if (graph[t1][t2] == 0) {
                        continue;
                    }//если ребра нет, идём дальше
                    /*ребро между этими двумя вершинами
                    меньше чем наше минимальное ребро?*/
                    if ((min_edge > graph[t1][t2]) || (cur_top == -1)) {
                        //если да, то это ребро становится минимальным
                        cur_top = t2;
                        min_edge = graph[t1][t2];
                    }
                }
            }
            min_way += min_edge;//добавляем вес минимального ребра
            top_ost.add(cur_top);//добавляем вершину в остов
            other_top.remove(new Integer(cur_top));//убираем вершину из "остальных"
        }
        return min_way;
    }

    static int getMinWay2(int[][] graph) {
        int min_way = 0;
        int n = graph.length;
        //создаём граф, содержащий n вершин по матрице смежности
        //Каждая вершина Node содержит список смежных
        //с ней вершин в паре с весом их общего ребра,
        //отсортированный по весам в порядке возрастания
        Graph g = new Graph(n).addEdges(graph);
        Node fnode = g.nodes[0];
        boolean[] ready = new boolean[n];
        //список вершин в остове
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(fnode);
        ready[0] = true;
        while (nodes.size() != n) {//проходим по остову
            //минимальное неопределённое ребро
            Pair pair = new Pair(null, Integer.MAX_VALUE);
            for (Node node : nodes) {
                //для каждой вершины ищем минимальное ребро
                //Первая вершина не из остова и будет
                //с минимальным ребром из нашей вершины
                for (Pair p : node.pairs) {
                    if (ready[p.node.name]) {
                        continue;
                    }
                    if (pair.ves > p.ves) pair = p;
                    break;
                }
            }
            ready[pair.node.name] = true;
            nodes.add(pair.node);
            min_way += pair.ves;
        }
        return min_way;
    }
}
