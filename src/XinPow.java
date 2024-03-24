import java.util.Date;

public class XinPow {
    static long getTime() {
        return System.nanoTime();
        //return (new Date()).getTime();
    }

    static double bad(double x, int p) {
        double res = 1;
        for (int i = 0; i < p; i++) {
            res *= x;
        }
        return res;
    }

    static double notbad(double x, int p) {
        double res = x;
        long cnt = 1;
        while (cnt * 2 <= p) {
            res *= res;
            cnt *= 2;
        }
        while (cnt < p) {
            res *= x;
            cnt++;
        }
        return p > 0 ? res : 1;
    }

    static double my(double x, int p, long c) {
        if (p == c) {
            return 1;
        }
        double res = x;
        long cnt = 1;
        while (c + cnt * 2 <= p) {
            res *= res;
            cnt *= 2;
        }
        return res * my(x, p, cnt + c);
    }

    static double good(double x, int p) {
        if (p == 1) return x;
        if (p % 2 == 1) return x * good(x, p - 1);
        double x2 = good(x, p / 2);
        return x2 * x2;
    }

    public static void main(String[] args) {
        double x = 1.0000001;
        int p = 2147483647;
        long t = getTime();
        System.out.println(bad(x, p));
        System.out.println(getTime() - t);
        t = getTime();
        System.out.println(notbad(x, p));
        System.out.println(getTime() - t);
        t = getTime();
        System.out.println(my(x, p, 0));
        System.out.println(getTime() - t);
        t = getTime();
        System.out.println(good(x, p));
        System.out.println(getTime() - t);
    }
}
