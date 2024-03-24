package Queue;

public class Main {
    public static void main(String[] args) {
        QueueStack<Integer> queue = new QueueStack();
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 10; j++) {
                queue.push(j+10*i);
            }
            for (int j = 0; j < 9; j++) {
                System.out.println(queue.peek()+" "+ queue.pop());
            }
        }
    }
}
