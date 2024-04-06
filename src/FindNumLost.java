public class FindNumLost {
    static int findNumLost(int[] a){
        int max = a[0];
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(max, a[i]);
            sum += a[i];
        }
        return (int)(((1+max)/2d)*max-sum);
    }
    public static void main(String[] args) {
        System.out.println(findNumLost(new int[]{1, 2, 3, 4, 6, 7, 8}));
    }
}
