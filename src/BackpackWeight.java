public class BackpackWeight {
    public static void main(String[] args) {
        int maxw = 15;
        O[] bp = new O[]{new O(1, 2), new O(3, 2), new O(4, 5),
                new O(2, 4), new O(6, 3), new O(3, 6),
                new O(3, 3), new O(1, 3), new O(2, 1),};
        int[][] R = new int[bp.length][maxw];
        for (int i = 1; i < bp.length; i++) {
            for (int j = 0; j < maxw; j++) {
                if (j - bp[i].w >= 0) {
                    R[i][j] = Math.max(R[i - 1][j - bp[i].w] + bp[i].p, R[i - 1][j]);
                } else {
                    R[i][j] = R[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < bp.length; i++) {
            max = Math.max(max, R[i][R.length - 1]);
        }
        System.out.println(max);
    }
}

class O {
    int p;
    int w;

    public O(int p, int w) {
        this.p = p;
        this.w = w;
    }
}