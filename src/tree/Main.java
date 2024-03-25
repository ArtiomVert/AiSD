package tree;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 2, 1, 7, 6, 8, 9};
        BinTree tree = new BinTree();
        for (int a1 : a) {
            tree.push(a1);
        }
        System.out.println(tree.serch(4));
        System.out.println(tree.serch(16));
    }
}
