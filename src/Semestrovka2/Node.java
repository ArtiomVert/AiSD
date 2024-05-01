package Semestrovka2;

class Node {
    int key;
    Semestrovka2.Node parent = null;
    Semestrovka2.Node child = null;
    Semestrovka2.Node left = null;
    Semestrovka2.Node right = null;
    int degree = 0;
    boolean mark = false;

    public Node(int key) {
        this.key = key;
    }
}

