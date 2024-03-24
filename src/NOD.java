public class NOD {
    static int good(int m, int n) {
        while (m!=0 && n!=0) {
            if (m > n) {
                m %= n;
            } else {
                n %= m;
            }
        }
        return n+m;
    }

    static int bad(int m, int n) {
        while (m!=n) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int n = 1;
        System.out.println(good(m, n));
        System.out.println(bad(m, n));
    }
}
