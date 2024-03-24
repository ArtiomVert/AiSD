import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class XisPrime {
    static boolean isPrimeNotbad(int x) {
        for (int i = 3; i < sqrt(x + 1); i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return x == 2 || x % 2 == 1;
    }
    static List<Integer> primesDels(int x){
        List<Integer> dels = new ArrayList<Integer>();
        int i = 2;
        while (x>1){
            if (x%i==0){
                x/=i;
                dels.add(i);
            }
            else{
                i++;
            }
        }
        return dels;
    }

    public static void main(String[] args) {
        int x = 182146734;
        System.out.println(primesDels(x));
    }
}
