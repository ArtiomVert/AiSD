import java.util.Random;

public class Ferma {
    static boolean isPrimeMR(int n) {
        Random r = new Random();
        for (int i = 0; i < 200; i++) {
            long a = 1+r.nextInt(n-1);
            a = (long) Math.pow(a, n - 1);
            if ((a % n) != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrimeMR(23));
    }
}
