package Queue;

import java.util.Stack;

public class QueueStack<T> {
    Stack<T> push_stack = new Stack<>();
    Stack<T> pop_stack = new Stack<>();

    public void push(T t) {
        push_stack.push(t);
    }

    private void pushToPop() {
        while (!push_stack.isEmpty()){
            pop_stack.push(push_stack.pop());
        }
    }

    public T pop() {
        if (pop_stack.isEmpty()) {
            pushToPop();
        }
        return pop_stack.pop();
    }

    public T peek() {
        if (pop_stack.isEmpty()) {
            pushToPop();
        }
        return pop_stack.peek();
    }

    public boolean isEmpty() {
        return push_stack.isEmpty() && pop_stack.isEmpty();
    }
}
