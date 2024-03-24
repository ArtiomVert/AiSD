import java.util.Date;

public class Fib {
    static int fib2(int n){//O(2^n)
        if (n==1 || n==2) return 1;
        return fib2(n-1) + fib2(n-2);
    }
    static int fib(int n) {//O(n)
        int a = 1;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

    static long getTime(){
        return (new Date()).getTime();
    }
    public static void main(String[] args) {
        long t = getTime();
        System.out.println(fib(64));
        System.out.println(getTime() - t);
        t = getTime();
        System.out.println(fib2(64));
        System.out.println(getTime() - t);
    }
}
