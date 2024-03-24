package Sorts;

import java.util.Arrays;

public class MergeSort implements Sort {

    public String toString() {
        return "MergeSort - ";
    }

    public int[] sort(int[] list) {
        if (list.length <= 1) {
            return list;
        }
        int m = list.length / 2;
        int[] a = new int[m];
        System.arraycopy(list, 0, a, 0, m);
        m = m + list.length % 2;
        int[] b = new int[m];
        System.arraycopy(list, a.length, b, 0, m);
        a = sort(a);
        b = sort(b);
        return merge(a, b);
    }

    private static int[] merge(int[] a, int[] b) {
        int n = a.length + b.length;
        int[] c = new int[n];
        int ci = 0;
        int ca = 0;
        int cb = 0;
        while (ci < n) {
            if (ca == a.length || (cb != b.length && a[ca] >= b[cb])) {
                c[ci] = b[cb];
                ci++;
                cb++;
            } else {
                c[ci] = a[ca];
                ci++;
                ca++;
            }
        }
        return c;
    }
}