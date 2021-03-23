import java.util.Stack;

public class queueUsingStack_push {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int topVal = 0;

    public int size(){
        return st.size();
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    //O(1)
    public void push(int data){
        if(st.isEmpty())
            topVal = data;
        st.push(data);    
    }

    //O(1)
    public int front(){
        return topVal;
    }

    //O(n)
    private void transferToAnotherStack() {
        while (st.size() != 0) {
            temp.push(st.pop());
        }
    }

    public int pop(){
        transferToAnotherStack();
        int rData = temp.pop();
        while (temp.size() != 0) {
            this.push(temp.pop());
        }
        return rData;
    }
}
