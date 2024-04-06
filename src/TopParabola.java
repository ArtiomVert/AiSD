public class TopParabola {
    static int findTop(int[] a) {
        int r = a.length - 1;
        int l = 0;
        int m = (l + r) / 2;
        while (!(a[m - 1] < a[m] && a[m + 1] < a[m])) {
            if (a[m] < a[m + 1]) {
                l = m;
            } else {
                r = m;
            }
            m = (l + r) / 2;
        }
        return a[m];
    }

    public static void main(String[] args) {
        System.out.println(findTop(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 2, 1}));
    }
}
