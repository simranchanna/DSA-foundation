import java.util.ArrayList;

public class genericTrees {
    public static class Node{
        int data = 0;
        ArrayList<Node> children;
        Node(int data){
            this.data = data;
        }
    }

    public static int size(Node node){
        int size = 0;
        for(Node child : node.children){
            size += size(child);
        }
        return size + 1;
    }

    public static int height(Node node){
        int h = -1;
        for(Node child : node.children){
            h = Math.max(h, height(child));
        }
        return h + 1;
    }

    public static int maximum(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
          int x = max(child);
          max = Math.max(max, x);
        }
        max = Math.max(max, node.data);
        return max;
    }

    public static boolean find(Node node, int data) {
        if(node.data == data)
            return true;
        for(Node child : node.children){
            if(find(child, data))
                return true;
        }
        return false;    
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(node.data == data){
            list.add(node.data);
            return list;
        }
        for(Node child : node.children){
            if(find(child, data)){
                list = nodeToRootPath(child, data);
                list.add(node.data);
                return list;
            }    
        }
        return list;
    }

}
