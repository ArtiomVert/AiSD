public class PreMax {
    public static void main(String[] args) {
        int[] a = {5, 6, 2, 6, 3, 9, 14, 17, 12, 11, 15, 10};
        int max = a[0];
        for (int i: a){
            max = Math.max(max, i);
        }
        Integer preMax = null;
        for (int i: a){
            if(i != max){
                if(preMax == null){
                    preMax = i;
                }
                preMax = Math.max(preMax, i);
            }
        }
        System.out.println(preMax);
    }
}
