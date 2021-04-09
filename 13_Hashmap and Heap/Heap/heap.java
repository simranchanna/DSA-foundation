import java.util.ArrayList;

public class heap {
    
    public ArrayList<Integer> arr;
    public int size;

    //CONSTRUCTOR====================
    private void initialize(){
        this.arr = new ArrayList<>();
        this.size = 0;
    }
    public heap(){
        initialize();
    }

    public heap(int[] arr){
        initialize();
        for(int ele : arr){
            this.add(ele);
        }
    }

    //GENERAL FUNCTIONS====================
    public void display(){
        for(int ele : this.arr){
            System.out.println(ele);
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void swap(int i, int j){
        int ei = this.arr.get(i);
        int ej = this.arr.get(j);
        this.arr.set(i, ej);
        this.arr.set(j, ei);
    }

    private void upheapify(int idx){
        int pi = (idx - 1) / 2;
        if(pi >= 0 && this.arr.get(pi) < this.arr.get(idx)){
            swap(pi, idx);
            upheapify(pi);
        }    
    }

    private void downheapify(int pi){
        int maxIdx = pi;
        int lci = (2 * pi) + 1;
        int rci = (2 * pi) + 2;
        if(lci < this.arr.size() && this.arr.get(maxIdx) < this.arr.get(lci))
            maxIdx = lci; 
        if(rci < this.arr.size() && this.arr.get(maxIdx) < this.arr.get(rci))
            maxIdx = rci;
        if(maxIdx != pi){
            swap(maxIdx, pi);
            downheapify(maxIdx);
        }        
    }
    
    public void add(int data){
        this.arr.add(data);
        this.size++;
        upheapify(this.size - 1);
    }

    public int remove(){
        int rv = this.arr.get(0);
        swap(0, this.size - 1);
        this.arr.remove(this.size - 1);
        downheapify(0);
        return rv;
    }

    public int peek(){
        return this.arr.get(0);
    }

}

