package Semestrovka;

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
        FileWriter wf1 = new FileWriter("DataTime.txt", true);
        FileWriter wf2 = new FileWriter("DataIter.txt", true);
        for (int i = 100; i < 10_001; i += 100) {
            int[][] g = genGraph(i);
            long time1;
            long time2;
            long t = getTime();
            long res1 = MinWay.getMinWay1(g);
            time1 = getTime() - t;
            t = getTime();
            long res2 = MinWay.getMinWay2(g);
            time2 = getTime() - t;
            wf1.write(i + " " + time1 + " " + time2 + "\n");
            wf2.write(i + " " + res1 + " " + res2 + "\n");
            wf1.flush();
            wf2.flush();
            System.out.println(i + " Ok " + time1 + " / " + time2);
        }
        wf1.close();
        wf2.close();
    }
}
