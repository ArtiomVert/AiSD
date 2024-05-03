package Semestrovka2;

public class FibHeap {
    Node min = null;
    int size = 0;
    long iters = 0;

    public int getMin() {
        return min.key;
    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (size == 0) {
            min = newNode;
            min.left = newNode;
            min.right = newNode;
        } else {
            Node prevRight = min.right;
            min.right = newNode;
            newNode.left = min;
            newNode.right = prevRight;
            prevRight.left = newNode;
        }
        if (newNode.key < min.key) {
            min = newNode;
        }
        size++;
    }

    private void unionLists(Node first, Node second) {
        if (second == null) {
            return;
        }
        Node l = first.left;
        Node r = second.right;
        second.right = first;
        first.left = second;
        l.right = r;
        r.left = l;
    }

    private void delPar(Node n) {
        if (n == null) return;
        Node cur = n;
        do {
            cur.parent = null;
            cur = cur.right;
        } while (cur != n);
    }

    public int deleteMin() {
        Node prevMin = min;
        delPar(min.child);
        unionLists(min, min.child);
        Node l = min.left;
        Node r = min.right;
        l.right = r;
        r.left = l;
        if (prevMin.right == prevMin) {
            min = null;
            size = 0;
            return prevMin.key;
        }
        min = min.right;
        consolidate();
        size--;
        return prevMin.key;
    }
    private int getPow(){
        int a = size;
        int res = 0;
        while (a!=0) {
            res++;
            a/=2;
        }
        return res;
    }
    private void consolidate() {
        Node[] A = new Node[getPow()];
        Node current = min;
        Node flag = null;
        while (flag != current) {
            iters++;
            if (A[current.degree] == null) {
                A[current.degree] = current;
                flag = current;
                current = current.right;
            } else if (A[current.degree] == current) {
                current = current.right;
            } else {
                Node conflict = A[current.degree];
                A[current.degree] = null;
                Node addTo;
                Node adding;
                if (conflict.key < current.key) {
                    addTo = conflict;
                    adding = current;
                } else {
                    addTo = current;
                    adding = conflict;
                }
                Node l = adding.left;
                Node r = adding.right;
                l.right = r;
                r.left = l;
                adding.left = adding;
                adding.right = adding;
                if (addTo.child == null) {
                    addTo.child = adding;
                } else {
                    unionLists(addTo.child, adding);
                }
                adding.parent = addTo;
                addTo.degree++;
                current = addTo;
                flag = null;
            }
            if (min.key > current.key) {
                min = current;
            }
        }
    }

    public Node find(int x) {
        return findRec(x, min);
    }

    private Node findRec(int x, Node n) {
        if (n == null) return null;
        Node cur = n;
        do {
            iters++;
            if (cur.key == x) return cur;
            if (cur.key < x) {
                Node res = findRec(x, cur.child);
                if (res != null) return res;
            }
            cur = cur.right;
        } while (cur != n);
        return null;
    }


    public void delete(Node x) {
        if (x.parent == null) {
            x.key = Integer.MIN_VALUE;
            min = x;
            deleteMin();
            return;
        }
        Node parent = x.parent;
        x.key = Integer.MIN_VALUE;
        cut(x);
        cascadingCut(parent);
        deleteMin();
    }

    private void cut(Node x) {
        Node L = x.left;
        Node R = x.right;
        R.left = L;
        L.right = R;
        x.parent.degree--;
        if (x.parent.child == x) {
            if (x.right == x) {
                x.parent.child = null;
            } else {
                x.parent.child = x.right;
            }
        }
        x.right = x;
        x.left = x;
        x.parent = null;
        unionLists(min, x);
        if (x.key < min.key) {
            min = x;
        }
    }

    private void cascadingCut(Node x) {
        while (x.mark & x.parent != null) {
            iters++;
            Node parent = x.parent;
            cut(x);
            x = parent;
        }
        x.mark = true;
    }
}


