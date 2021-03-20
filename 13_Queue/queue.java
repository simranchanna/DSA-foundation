public class queue {
    protected int[] arr = null;
    protected int capacity = 0;
    protected int elementCount = 0;
    protected int front = 0;
    protected int back = 0;

    //CONSTRUCTOR====================
    protected void initializeVars(int capacity){
        this.capacity = capacity;
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.tos = -1;
    }
    public stack(){
        initializeVars(10);
    }
    public stack(int size){
        initializeVars(size);
    }

    //BASIC FUNCTIONS====================
    public int size(){
        return this.elementCount;
    }
    public boolean isEmpty(){
        return this.elementCount == 0;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<this.elementCount; i++){
            int idx = (this.front + i) % this.capacity;
            sb.append(this.arr[idx]);
        }
        sb.append("]");
        return sb.toString();
    }

    //EXCEPTIONS====================
    private void overflow() throws Exception{
        if(this.capacity == this.elementCount)
            throw new Exception("Stack is Full");
    }
    private void underflow() throws Exception{
        if(this.elementCount == 0)
            throw new Exception("Stack is Empty");
    }

    //STACK FUNCTIONS====================
    protected void push_(int data){
        this.arr[++this.tos] = data;
        this.elementCount++;   
    }
    public void push(int data) throws Exception{
        overflow();
        push_(data);
    }
    public int top() throws Exception{
        underflow();
        return this.arr[this.tos];
    }
    public int pop() throws Exception{
        underflow();
        int rv = this.arr[this.front];
        this.arr[this.front] = 0;
        this.elementCount--;
        return rv;
    }
}
