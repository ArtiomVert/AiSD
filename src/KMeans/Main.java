package KMeans;

import java.util.Random;

public class Main {
    static boolean in(Point[] ps, Point p) {
        for (Point p1 : ps) {
            if (p1 == null) {
                return false;
            }
            if ((p1.x == p.x) & (p1.y == p.y)) return true;
        }
        return false;
    }

    static Point[] gen(int n) {
        Point[] ps = new Point[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            Point p = new Point(r.nextInt(n * 2), r.nextInt(n * 2));
            while (in(ps, p)) {
                p = new Point(r.nextInt(n * 2), r.nextInt(n * 2));
            }
            ps[i] = p;
        }
        return ps;
    }

    static long getIime() {
        return System.nanoTime() / 1000000;
    }

    public static void main(String[] args) {
        for (int i = 500; i < 10000; i += 500) {
            Point[] p = gen(i);
            long t = getIime();
            double d1 = KMeans.stup(p);
            System.out.print(getIime() - t + " - ");
            t = getIime();
            double d2 = KMeans.getMin(p);
            System.out.println(getIime() - t + " " + d1 + " " + d2);
        }
    }
}
