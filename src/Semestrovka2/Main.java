package Semestrovka2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n-i;
        }
        Random r = new Random();
        for(int i = 2; i < n; i++) {
            int index = r.nextInt(i);
            int t = a[index];
            a[index] = a[i];
            a[i] = t;
        }
        FibHeap fh = new FibHeap();
        for (int i = 0; i < n; i++) {
            fh.insert(a[i]);
        }

        for (int i = 0; i < n; i++){
            System.out.println(fh.deleteMin()+" "+fh.size);
        }
    }
}
