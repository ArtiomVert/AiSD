public class SumTree {
    static void sumTree(Node t1, Node t2, Node t3) {
        if (t1 == null) {
            t3.data = t2.data;
            t3.left = t2.left;
            t3.right = t2.right;
            return;
        }
        if (t2 == null) {
            t3.data = t1.data;
            t3.left = t1.left;
            t3.right = t1.right;
            return;
        }
        t3.data = t1.data + t2.data;
        if (t1.left != null || t2.left != null){
            t3.left = new Node(0);
            sumTree(t1.left, t2.left, t3.left);
        }

        if (t1.right != null || t2.right != null){
            t3.right = new Node(0);
            sumTree(t1.right, t2.right, t3.right);
        }
    }
    static Node sumTree(Node t1, Node t2){
        if (t1==null && t2 == null){
            return null;
        }
        if (t1==null){
            return t2;
        }
        if (t2==null){
            return t1;
        }
        Node nn = new Node(t1.data+t2.data);
        nn.left = sumTree(t1.left, t2.left);
        nn.right = sumTree(t1.right, t2.right);
        return nn;
    }
    static void print(Node n){
        System.out.println(n.data);
        if(n.left!=null){
            print(n.left);
        }
        if(n.right!=null){
            print(n.right);
        }
    }

    public static void main(String[] args) {
        Node tree1 = new Node(3);
        tree1.left = new Node(2);
        tree1.right = new Node(6);
        tree1.left.right = new Node(5);
        tree1.right.left = new Node(8);
        tree1.right.right = new Node(11);
        Node tree2 = new Node(7);
        tree2.left = new Node(5);
        tree2.right = new Node(11);
        tree2.left.left = new Node(3);
        tree2.right.left = new Node(8);
        tree2.right.right = new Node(9);
        Node tree3 = new Node(0);
        sumTree(tree1, tree2, tree3);
        print(tree3);
        print(sumTree(tree1, tree2));
    }
}

class Node {
    int data;
    Node left = null;
    Node right = null;

    public Node(int data) {
        this.data = data;
    }
}