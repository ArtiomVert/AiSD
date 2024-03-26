package Semestrovka;

import Semestrovka.Graph.Graph;

import java.io.*;
import java.util.Random;

public class Main {
    public static long getTime() {
        return System.nanoTime() / 1000000;
        //return (new Date()).getTime();
    }

    public static int[][] genGraph(int n) {
        int[][] g = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = 1 + r.nextInt(50);
                g[i][j] = l;
                g[j][i] = l;
            }
        }
        return g;
    }

    public static void main(String[] args) throws IOException {
        FileWriter wf = new FileWriter("Data.txt", false);
        for (int i = 100; i < 10_001; i += 100) {
            int[][] g = genGraph(i);
            long t = getTime();
            int res1 = MinWay.getMinWay1(g);
            wf.write(i + " " + (getTime() - t));
            int res2 = 0;
            t = getTime();
            try {
                res2 = MinWay.getMinWay2(g);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            wf.write(" " + (getTime() - t) + "\n");
            wf.flush();
            System.out.println(i + " Ok " + (res1==res2));
        }
        wf.close();
    }
}
