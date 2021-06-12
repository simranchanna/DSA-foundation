import java.util.HashMap;

//LEETCODE 146 (This problem is implemented using hashmap and doubly linked list)
class LRUCache {

    private class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0; //size of linkedlist
    private int capacity = 0;
    private HashMap<Integer, Node> map = new HashMap<>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    private void removeNode(Node node){
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else if(node.prev == null){
            node.next.prev = null;
            this.head = node.next;

        }    
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = node.next = null;
        this.size--;
    }
    private void addLast(Node node){
        if(this.size == 0){
            this.head = this.tail = node;
            this.size++;
            return;
        }
        Node prevNode = this.tail;
        prevNode.next = node;
        node.prev = prevNode;
        this.tail = node;
        this.size++;
    }
    private void makeRecent(Node node){
        if(this.tail == node)
            return;
        removeNode(node);
        addLast(node);    
    }
    //key = app
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        makeRecent(node);
        return node.value;    
    }
    
    //key = app, value = state
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            makeRecent(node);
        }
        else{
            if(this.size == this.capacity){
                int rKey = this.head.key;
                removeNode(this.head);
                map.remove(rKey);
            }
            Node node = new Node(key, value);
            addLast(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */