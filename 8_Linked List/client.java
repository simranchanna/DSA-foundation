import java.util.LinkedList;

public class client {

    public static void main(String[] args) throws Exception{
        LinkedList list = new LinkedList();
        //Scanner scn = new Scanner(System.in);
        // System.out.println("Enter your choice : ");
        // System.out.println("0. Exit");
        // System.out.println("1. Add First");
        // System.out.println("2. Add Last");
        // System.out.println("3. Add At Index");
        // System.out.println("4. Remove First");
        // System.out.println("5. Remove Last");
        // System.out.println("6. Remove At Index");
        // System.out.println("7. Get First");
        // System.out.println("8. Get Last");
        // System.out.println("9. Get At Index");
        // System.out.println("10. Display the list");
        // System.out.println("11. Get Mid");
        // int c = scn.nextInt();
        // while(c != 0){
        //     switch(c){
        //         case 1:
        //             System.out.print("Enter the element : ");
        //             int x = scn.nextInt();
        //             list.addFirst(x);
        //             break;
        //         case 2:
        //             System.out.print("Enter the element : ");
        //             int x = scn.nextInt();
        //             list.addLast(x);
        //             break;    
        //         case 10:
        //             list.display();
        //             break;    
        //         default:
        //             System.out.println("Invalid Input!!"); 
        //             break;   
        //     }
        //     c = scn.nextInt();
        // }
    list.addFirst(10); 
    list.addLast(20);
    list.addAt(2,30);
    list.addLast(40);
    list.addLast(50);
    System.out.println(list.size());
    System.out.println(list.mid());
    list.removeFirst();
    list.removeLast();
    list.removeAt(1);
    list.display();    
    list.addFirst(10); 
    list.addLast(20);
    list.addAt(2,30);
    list.addLast(40);
    list.addLast(50);
    System.out.println(list.getFirst());
    System.out.println(list.getLast());
    System.out.println(list.getAt(5));
    list.display();
    }

    public static class LinkedList{
        private class Node{
            int data = 0;
            Node next = null;
            Node(int data){
                this.data = data;
            }
        }
        private Node head = null;
        private Node tail = null;
        private int sizeofLL = 0;
    
        public int size(){
            return this.sizeofLL;
        }
        public boolean isEmpty(){
            return this.sizeofLL == 0;
        }
    
        //Exception handling
        public void EmptyException() throws Exception{
            if(this.sizeofLL == 0){
                throw new Exception("Linked List is empty!!!");
            }
        }
        public void indexOutOfBoundSizeInclusive(int idx) throws Exception{
            if(idx < 0 || idx >= this.sizeofLL){
                throw new Exception("Index out of bound : -1");
            }
        }
        public void indexOutOfBoundSizeExclusive(int idx) throws Exception{
            if(idx < 0 || idx > this.sizeofLL){
                throw new Exception("Index out of bound : -1");
            }
        }
        //GETTING A NODE==========================================================
        public int getFirst() throws Exception {
            EmptyException();
            return this.head.data;
        }
        public int getLast() throws Exception {
            EmptyException();
            return this.tail.data;
        }
    
        private Node getNodeAt(int idx) {
            Node curr = this.head;
            for(int i=0; i<idx; i++){
                curr = curr.next;
            }
            return curr;
        }
        public int getAt(int idx) throws Exception {
            indexOutOfBoundSizeInclusive(idx);
            Node node = getNodeAt(idx);
            return node.data;
        }
        //ADDING A NODE===========================================================
        //Add first
        private void addFirstNode(Node node){
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else{
                node.next = this.head;
                this.head = node;
            }
            this.sizeofLL++;
        }
        public void addFirst(int data){
            Node node = new Node(data);
            addFirstNode(node);
        }
        //Add last
        private void addLastNode(Node node){
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else{
                this.tail.next = node;
                this.tail = node;
            }
            this.sizeofLL++;
        }
        public void addLast(int data){
            Node node = new Node(data);
            addLastNode(node);
        }
        //Add at given index
        private void addAtNode(int idx, Node node){
            if(idx == 0)
                addFirstNode(node);
            else if(idx == this.sizeofLL)
                addLastNode(node);
            else{
                Node prev = getNodeAt(idx-1);
                Node forw = prev.next;
                prev.next = node;
                node.next = forw;
                this.sizeofLL++;
            }     
        }
        public void addAt(int idx, int data) throws Exception{
            indexOutOfBoundSizeExclusive(idx);
            Node node = new Node(data);
            addAtNode(idx, node);
        }
        //REMOVING A NODE============================================
        //remove first
        private Node removeFirstNode(){
            Node node = this.head;
            if (this.sizeofLL == 1) {
                this.head = this.tail = null;
            }
            else{
                Node forw = this.head.next;
                node.next = null;
                this.head = forw;
            }
            this.sizeofLL--;
            return node;
        }
        public int removeFirst() throws Exception{
            EmptyException();
            Node node = removeFirstNode();
            return node.data;
        }
        //remove last
        private Node removeLastNode(){
            Node node = this.tail;
            if (this.sizeofLL == 1) {
                this.head = this.tail = null;
            }
            else{
                Node prev = this.head;
                for(int i=0; i<this.sizeofLL-2;i++){
                    prev = prev.next;
                }
                prev.next = null;
                this.tail = prev;
            }
            this.sizeofLL--;
            return node;
        }
        public int removeLast() throws Exception{
            EmptyException();
            Node node = removeLastNode();
            return node.data;
        }
        //remove at given index
        private Node removeAtNode(int idx){
            Node curr = null;
            if(idx == 0){
                curr = removeFirstNode(); 
            }    
            else if(idx == this.sizeofLL-1){
                curr = removeLastNode();
            }
            else{
                Node prev = getNodeAt(idx-1);
                curr = prev.next;
                Node forw = curr.next;
                prev.next = forw;
                curr.next = null;
                this.sizeofLL--;
            }
            return curr;
        }
        public int removeAt(int idx) throws Exception{
            indexOutOfBoundSizeInclusive(idx);
            EmptyException();   
            Node node = removeAtNode(idx);
            return node.data;    
        }
    
        //DISPLAY===========================================
        public void display(){
            Node curr = this.head;
            while(curr != null){
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
        //MID OF LIST=======================================
        public int mid(){
            Node slow = this.head;
            Node fast = this.head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }
    
    }
}
