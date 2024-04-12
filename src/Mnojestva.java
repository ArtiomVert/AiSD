import java.util.ArrayList;
import java.util.Arrays;

public class Mnojestva {
    static Integer[] exept(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int indexB = 0;
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            while ((indexB < b.length) && (b[indexB] < a[i])) {
                indexB++;
            }
            if (indexB == b.length) {
                out.add(a[i]);
                continue;
            }
            if (b[indexB] != a[i]) {
                out.add(a[i]);
            }
        }
        return (Integer[]) out.toArray();
    }

    public static void main(String[] args) {

    }
}
