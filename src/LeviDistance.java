public class LeviDistance {
    public static void main(String[] args) {
        String a = "aslkgsdj";
        String b = "asljpkgsqj";
        int[][] R = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    R[i][j] = Math.max(i, j);
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    R[i][j] = Math.min(R[i - 1][j - 1], Math.min(R[i][j - 1], R[i - 1][j]) + 1);
                } else {
                    R[i][j] = Math.min(R[i - 1][j - 1], Math.min(R[i][j - 1], R[i - 1][j])) + 1;
                }
            }
        }
        System.out.println(R[a.length()][b.length()]);
    }
}
