import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class PipetsZadacha {
    static long bad(int[] a){
        long op = 0;
        int[] b = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            for (int j = i-1; j >=0; j--) {
                op++;
                if(a[i]>a[j]){
                    b[i] = a[j];
                    break;
                }
                b[i] = 0;
            }
        }
        return op;
    }
    static long good(int[] a){
        long op = 0;
        int[] b = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty()){
                op++;
                int t = s.peek();
                if(t<a[i]){
                    b[i] = t;
                    s.push(a[i]);
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()){
                b[i] = 0;
                s.push(a[i]);
                op++;
            }
        }
        return op;
    }
    public static void main(String[] args) {
        int[] a = new int[5000000];
        for (int i = 0; i < 5000000; i++) {
            a[i] = (new Random()).nextInt(10000000);
        }
        //System.out.println(Arrays.toString(bad(a)).equals(Arrays.toString(good(a))));
        System.out.println(bad(a));
        System.out.println(good(a));
    }
}
