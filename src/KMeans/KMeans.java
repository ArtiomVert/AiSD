package KMeans;

import java.util.Arrays;

public class KMeans {

    static public double stup(Point[] p){
        double min = getD(p[0], p[1]);
        for (int i = 0; i < p.length-2; i++) {
            for (int j = i+1; j < p.length-1; j++) {
                min = Math.min(min, getD(p[i], p[j]));
            }
        }
        return min;
    }

    static public double getMin(Point[] p) {
        int n = p.length;
        Arrays.sort(p, (o1, o2) -> {
            if (o1.x > o2.x) return 1;
            if (o1.x < o2.x) return -1;
            if (o1.y > o2.y) return 1;
            if (o1.y < o2.y) return -1;
            return 0;
        });
        return getMinRec(p, n);
    }

    static private double getD(Point p1, Point p2) {
        return Math.sqrt((p1.x + p2.x) * (p1.x + p2.x) + (p1.y + p2.y) * (p1.y + p2.y));
    }

    private static double getMinRec(Point[] p, int n) {
        if (p.length == 2) return getD(p[0], p[1]);
        if (p.length == 3) {
            return Math.min(getD(p[0], p[1]), Math.min(getD(p[0], p[2]), getD(p[1], p[2])));
        }
        int n2 = n / 2;
        Point[] p1 = new Point[n2];
        Point[] p2 = new Point[n2 + n % 2];
        for (int i = 0; i < n; i++) {
            if (i < n2) {
                p1[i] = p[i];
            } else {
                p2[i - n2] = p[i];
            }
        }
        return getMinPer(p1, p2, Math.min(getMinRec(p1, n2), getMinRec(p2, n2 + n % 2)));
    }

    static public void print(Point[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }
    }

    static private double getMinPer(Point[] p1, Point[] p2, double d) {
        int m = p2[p2.length - 1].x;
        for (int i = p1.length - 1; i >= 0; i--) {
            if (m - p1[i].x > d) break;
            for (int j = 0; j < p2.length - 1; j++) {
                if (p2[j].x - p1[i].x > d) break;
                double d1 = getD(p1[i], p2[j]);
                if (d1<d) return getMinPer(p1, p2, d1);
            }
        }
        return d;
    }
}
