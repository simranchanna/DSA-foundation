
public class client {
    public static void main(String[] args){
        int[] arr = {10,20,-2,-3,30,5,7,6,8,9,11,22,13,14};
        heap h = new heap(arr);
        System.out.println(h.size());
        h.display();
        // System.out.println(h.remove());
        // System.out.println(h.peek());
    }    
}
