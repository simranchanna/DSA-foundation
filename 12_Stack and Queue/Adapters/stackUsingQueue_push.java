import java.util.Queue;
import java.util.LinkedList;

public class stackUsingQueue_push {
    Queue<Integer> mainq = new LinkedList<>();
    Queue<Integer> tempq = new LinkedList<>();
    int topVal = 0;

    public int size() {
        return mainq.size();
    }

    public boolean isEmpty(){
        return mainq.isEmpty();
    }
  
    //O(1)
    public void push(int data) {
        mainq.add(data);
        topVal = data;
    }
  
    //O(1)
    public int peek() {
        return topVal;
    }
  
    //O(n)
    private void transferToAnotherQueue(){
        int size = mainq.size();
        for(int i=0; i<size-1; i++){
            tempq.add(mainq.remove());
        }
    }
    public int pop() {
        transferToAnotherQueue();
        int rv = mainq.remove();
        while(tempq.size() != 0){
            this.push(tempq.remove());
        }
        return rv;
    }
}
