import Sorts.Compare;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumberOfNumbers {
    static String q(Integer[] a){
        Arrays.sort(a, (o1, o2)->{
            return (o2+"").compareTo(o1+"");
        });
        String out = "";
        for (int q:a){
            out+=q;
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(q(new Integer[]{1, 2, 32, 33, 98, 9, 90}));
    }
}
