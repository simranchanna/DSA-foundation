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

    public static void display(Node node){
        System.out.print(node.data + " -> ");
        if(node.children.size() == 0){
            System.out.println(".");
            return;
        }
        for(Node child : node.children){
            System.out.print(child.data + ",");
        }
        System.out.println();
        for(Node child : node.children){
            display(child);
        }
        
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

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> list1 = nodeToRootPath(node, d1);
        ArrayList<Integer> list2 = nodeToRootPath(node, d2);
        int i = list1.size() - 1;
        int j = list2.size() - 1;  
        while(i>=0 && j>=0 && list1.get(i) == list2.get(j)){
            j--;
            i--;
        }
        j++;
        i++;
        return list1.get(i);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2){
        ArrayList<Integer> list1 = nodeToRootPath(node, d1);
        ArrayList<Integer> list2 = nodeToRootPath(node, d2);
        int i = list1.size() - 1;
        int j = list2.size() - 1;  
        int common = 0;
        while(i >= 0 && j >= 0 && list1.get(i) == list2.get(j)){
            common++;
            i--;
            j--;
        }
        int ans = list1.size() + list2.size() - (2 * common);
        return ans;
    }
   

}
