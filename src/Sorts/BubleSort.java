package Sorts;

import java.util.Arrays;

public class BubleSort implements Sort {

    public String toString() {
        return "BubleSort - ";
    }

    public int[] sort(int[] a) {
        int n = a.length;
        int[] list = new int[n];
        System.arraycopy(a, 0, list, 0, n);
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[i] < list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }


}