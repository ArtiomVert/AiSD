import java.util.Arrays;

public class CountDif {
    static int q1(int[] a){
        int count = 1;
        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]!=a[i+1]) count++;
        }
        return count;
    }
    static int q2(int[] a, int k){
        int count = 0;
        boolean[] b = new boolean[k];
        for (int q: a) b[q] = true;
        for (boolean c: b) if(c) count++;
        return count;
    }
    public static void main(String[] args) {

    }
}
