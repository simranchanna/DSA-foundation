import java.util.Stack;

public class queueUsingStack_pop {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    public int size(){
        return st.size();
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    //O(n)
    private void transferToAnotherStack() {
        while (st.size() != 0) {
            temp.push(st.pop());
        }
    }
    public void add(int data){
        transferToAnotherStack();
        st.push(data);
        while (temp.size() != 0) {
            st.push(temp.pop());
        }
    }

    //O(1)
    public int peek(){
        if(st.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        return st.peek();
    }

    //O(1)
    public int remove(){
        if(st.size() == 0){
            System.out.println("Queue underflow");
            return -1;
        }
        return st.pop();
    }
}
