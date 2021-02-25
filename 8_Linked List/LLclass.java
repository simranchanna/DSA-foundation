public class LinkedList{
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
        return sizeofLL;
    }
    public boolean isEmpty(){
        return sizeofLL == 0;
    }

    //Exception handling
    public void EmptyException() throws Exception{
        if(this.sizeofLL == 0){
            throw new Exception("Linked List is empty!!!");
        }
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
            // node.next = this.head;
            // this.head = node;
        }
        this.sizeofLL++;
    }
    public void addLast(int data){
        Node node = new Node(data);
        addLastNode(node);
    }
    //Add at given index
    private void addAtNode(Node node, int idx){
        if(idx <= this.sizeofLL){
            Node head = this.head;
            for(int i=0; i<idx; i++){
                head = head.next;
            }
            node.next = head.next;
            head.next = node;
        }
    }
    public void addAt(int data, int idx){
        Node node = new Node(data);
        addAtNode(node, idx);
    }
    //REMOVING A NODE============================================
    //remove first
    private void removeFirstNode throws Exception(){
        EmptyException();
        this.head = this.head.next;
    }
    public void removeFirst(){
        removeFirstNode();
    }
    private void removeFirstNode throws Exception(){
        EmptyException();
        this.head = this.head.next;
    }
    public void removeFirst(){
        removeFirstNode();
    }
    

}