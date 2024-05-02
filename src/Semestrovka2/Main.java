package Semestrovka2;

import java.io.FileWriter;
import java.util.Random;

public class Main {
    public static long getTime() {
        return System.nanoTime();
    }

    public static void main(String[] args) throws Exception {
        int n = 10000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        Random r = new Random();
        for (int i = 2; i < n; i++) {
            int index = r.nextInt(i);
            int t = a[index];
            a[index] = a[i];
            a[i] = t;
        }
        FibHeap fh = new FibHeap();
        for (int i = 0; i < n; i++) {
            fh.insert(a[i]);
        }
        fh.insert(-1);
        fh.deleteMin();
        FileWriter wf1 = new FileWriter("src\\Semestrovka2\\DataFind.txt");
        FileWriter wf2 = new FileWriter("src\\Semestrovka2\\DataDel.txt");
        long[] mr = new long[]{0, 0, 0, 0};
        for (int i = 0; i < 100; i++) {
            fh.iters = 0;
            long t = getTime();
            Node q = fh.find(a[r.nextInt(n)]);
            t = getTime() - t;
            mr[0] += fh.iters;
            mr[1] += t;
            wf1.write(fh.iters + " " + t + "\n");
        }
        for (int i = 0; i < 1000; i++) {
            fh.iters = 0;
            long t = getTime();
            Node q = fh.find(a[i]);
            fh.delete(q);
            t = getTime() - t;
            mr[2] += fh.iters;
            mr[3] += t;
            wf2.write(fh.iters + " " + t + "\n");
        }
        wf1.close();
        wf2.close();
        for (int i = 0; i < 4; i++) {
            System.out.println(mr[i]/(i<2?100:1000));

        }
    }
}
