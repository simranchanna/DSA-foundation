import java.util.LinkedList;

public class client {

    public static void main(String[] args) throws Exception{
    LinkedList list = new LinkedList();
    list.addFirst(10); 
    list.addFirst(20); 
    list.addFirst(30); 
    list.addFirst(80);
    System.out.println(list.removeFirst());
    list.display();    
    }
}
