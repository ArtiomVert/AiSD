import javafx.collections.transformation.SortedList;

import java.util.List;
import java.util.Stack;

public class MyStack extends Stack<Integer> {
    Stack<Integer> minstack = new Stack<>();
    public Integer findMin(){
        return minstack.peek();
    }
    @Override
    public Integer push(Integer item) {
        if(item == null){
            throw new RuntimeException();
        }
        super.push(item);
        if(minstack.isEmpty()){
            minstack.push(item);
        } else if (minstack.peek()>=item){
            minstack.push(item);
        }
        return item;
    }

    @Override
    public synchronized Integer pop() {
        if(minstack.peek().equals(peek())){
            minstack.pop();
        }
        return super.pop();
    }
}
