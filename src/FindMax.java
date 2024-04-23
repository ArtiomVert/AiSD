public class FindMax {
    static int maxInArr(int st, int end, int[] a) {
        if (st - end == 1) {
            return Math.max(a[st], a[end]);
        }
        if (st - end == 0) {
            return a[st];
        }
        return Math.max(maxInArr(st, (st + end) / 2, a), maxInArr((st + end) / 2 + 1, end, a));
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 44, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        System.out.println(maxInArr(0, a.length - 1, a));
    }
}