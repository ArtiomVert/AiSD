public class Avtomat_i_sdacha {
    static Integer get(int[] a, int s, int ind) {
        if (s == 0) return 0;
        if (ind == 0) return null;
        Integer m = null;
        for (int i = 0; i <= s / a[ind - 1]; i++) {
            int new_s = s - i * a[ind - 1];
            Integer m1 = get(a, new_s, ind - 1);
            if (m1 == null) continue;
            if (m == null) {
                m = i + m1;
            } else {
                m = Math.min(m, i + m1);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nom = new int[]{1, 2, 5,  10};
        int need = 16;
        System.out.println(get(nom, need, nom.length));
    }
}
