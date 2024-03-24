package Queue;


public class Queue {
    private int size = 0;
    private int first = 0;
    private int last = -1;
    private final int N = 20;
    private int[] queue = new int[N];

    public void push(int a) throws RuntimeException {
        if (size == N) {
            throw new RuntimeException("Queue is overflow");
        }
        last++;
        last %= N;
        queue[last] = a;
        size++;
    }

    public int pop() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int q = peek();
        first++;
        first %= N;
        size--;
        return q;
    }

    public int peek() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[first];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}