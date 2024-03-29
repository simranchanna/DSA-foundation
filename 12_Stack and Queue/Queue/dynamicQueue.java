public class dynamicQueue extends queue {

    public dynamicQueue() {
        super();
    }

    public dynamicQueue(int size) {
        super(size);
    }

    public dynamicQueue(int[] arr) {
        super.initializeVars(2 * arr.length);
        for (int ele : arr)
            super.push_(ele);
    }

    @Override
    public void push(int data) throws Exception { 
        if (super.capacity == super.elementCount) {
            int n = super.capacity;
            int f = super.front;
            int[] temp = super.arr;
            super.initializeVars(2 * n);
            for (int i = 0; i < n; i++) {
                int idx = (f + i) % n;
                super.push_(temp[idx]);
            }
        }
        super.push_(data);
    }
}