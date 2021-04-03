import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_pop {
    Queue<Integer> mainq = new LinkedList<>();
    Queue<Integer> tempq = new LinkedList<>();

    public int size() {
        return mainq.size();
    }

    public boolean isEmpty(){
        return mainq.isEmpty();
    }
  
    //O(n)
    private void transferToAnotherQueue(){
        while(mainq.size() != 0){
            tempq.add(mainq.remove());
        }
    }
    public void push(int data) {
        transferToAnotherQueue();
        mainq.add(data);
        while(tempq.size() != 0){
            mainq.add(tempq.remove());
        }
    }
  
    //O(1)
    public int peek() {
        return mainq.peek();
    }
  
    //O(1)
    public int pop() {
        return mainq.remove();
    }
}
