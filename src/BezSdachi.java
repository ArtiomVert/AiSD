public class BezSdachi {
    static boolean get(int s, int[] a){
        if(s<0) return false;
        if(s==0) return true;
        for (int i = 0; i < a.length; i++) {
            int[] a2 = new int[a.length-1];
            for (int j = 0; j < i; j++) {
                a2[j] = a[j];
            }
            for (int j = i+1; j < a.length; j++) {
                a2[j-1] = a[j];
            }
            if (get(s-a[i], a2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 11, 3, 5};
        System.out.println(get(24, a));
        System.out.println(get(10, a));
        System.out.println(get(23, a));
        System.out.println(get(20, a));
        System.out.println(get(21, a));
    }
}
