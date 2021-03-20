public class stack {
    protected int[] arr = null;
    protected int capacity = 0;
    protected int elementCount = 0;
    protected int tos = -1;

    //CONSTRUCTOR====================
    protected void initializeVars(){
        this.arr = new int[this.capacity];
        this.elementCount = 0;
        this.tos = -1;
    }
    public stack(){
        this.capacity = 10;
        initializeVars();
    }
    public stack(int size){
        this.capacity = size;
        initializeVars();
    }

    //BASIC FUNCTIONS====================
    public int size(){
        return this.elementCount;
    }
    public boolean isEmpty(){
        return this.elementCount == 0;
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
    public void push(int data) throws Exception{
        overflow();
        this.arr[++this.tos] = data;
        this.elementCount++;
        
    }
    public int top() throws Exception{
        underflow();
        return this.arr[this.tos];
    }
    public int pop() throws Exception{
        underflow();
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.elementCount--;
        return rv;
    }
}
