public class Find_i_ai {
    static int find(int[] a) {
        int q = 0;
        while (q < a.length) {
            if (a[q] == q) return q;
            if (q < a[q]) q = a[q];
            if (q > a[q]) q++;
        }
        throw new RuntimeException("Not found");
    }

    static void find2(int s, int e, int[] a) {
        int m = (s + e) / 2;
        if (s > e) return;
        //if(s==a[s]) System.out.println(s);
        //if(e==a[e]) System.out.println(e);
        if (m == a[m]) System.out.println(m);
        if (a[e] >= m) find2(m + 1, e, a);
        if (a[s] <= m) find2(s, m - 1, a);
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        find2(0, a.length - 1, a);
    }
}
