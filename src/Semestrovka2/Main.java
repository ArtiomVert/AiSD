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
        long[] minr = new long[]{Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE};
        long[] maxr = new long[]{0, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            fh.iters = 0;
            long t = getTime();
            Node q = fh.find(i);
            t = getTime() - t;
            mr[0] += fh.iters;
            mr[1] += t;
            minr[0] = Math.min(minr[0], fh.iters);
            minr[1] = Math.min(minr[1], t);
            maxr[0] = Math.max(maxr[0], fh.iters);
            maxr[1] = Math.max(maxr[1], t);
            wf1.write(fh.iters + " " + t + "\n");
        }

        for (int i = 0; i < 1000; i++) {
            Node q = fh.find(a[n / 2 + i]);
            fh.iters = 0;
            long t = getTime();
            fh.delete(q);
            t = getTime() - t;
            mr[2] += fh.iters;
            mr[3] += t;
            minr[2] = Math.min(minr[2], fh.iters);
            minr[3] = Math.min(minr[3], t);
            maxr[2] = Math.max(maxr[2], fh.iters);
            maxr[3] = Math.max(maxr[3], t);
            wf2.write(fh.iters + " " + t + "\n");
        }
        wf1.close();
        wf2.close();
        System.out.println("Иттераций поиска " + minr[0] + " - " + mr[0] / n + " - " + maxr[0]);
        System.out.println("Время поиска " + minr[1] + " - " + mr[1] / n + " - " + maxr[1]);
        System.out.println("Иттераций удаления " + minr[2] + " - " + mr[2] / 1000 + " - " + maxr[2]);
        System.out.println("Время удаления " + minr[3] + " - " + mr[3] / 1000 + " - " + maxr[3]);
    }
}