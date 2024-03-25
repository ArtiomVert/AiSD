package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTree {
    Node root;

    public BinTree() {
        root = null;
    }

    public void push(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node cur = root;
        while (true) {
            if (data > cur.data) {
                if (cur.right == null) {
                    cur.right = new Node(data);
                    return;
                }
                cur = cur.right;
                continue;
            }
            if (data < cur.data) {
                if (cur.left == null) {
                    cur.left = new Node(data);
                    return;
                }
                cur = cur.left;
                continue;
            }
            return;
        }
    }

    public boolean serch(int data) {
        Node cur = root;
        while (cur != null) {
            if (data < cur.data) {
                cur = cur.left;
                continue;
            }
            if (data > cur.data) {
                cur = cur.right;
                continue;
            }
            return true;
        }
        return false;
    }
}
