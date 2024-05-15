import java.util.Arrays;

public class Vor {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 2, 4, 1, 6, 4,7, 4, 6, 2, 3, 1};
        int n = a.length;
        int m = 0;
        for (int i = 2; i < n; i++) {
            m = Math.max(m, a[i-2]);
            a[i] += m;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Math.max(a[n-1], a[n-2]));
    }
}
