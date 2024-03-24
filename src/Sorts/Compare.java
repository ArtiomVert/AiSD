package Sorts;

import java.util.Date;
import java.util.Random;

public class Compare {
    public static long getTime() {
        long t = System.nanoTime();
        return (new Date()).getTime();
    }

    public static void main(String[] args) {
        int n = 50000;
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(100);
            //a[i] = i;
        }
        Sort[] sorts = new Sort[]{new MergeSort(), new BubleSort()};
        for (Sort s : sorts) {
            long t = getTime();
            s.sort(a);
            System.out.println(s.toString() + (getTime() - t));
        }
    }
}
