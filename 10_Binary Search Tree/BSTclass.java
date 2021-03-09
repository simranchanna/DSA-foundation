public class BSTclass {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node constructTree(int[] arr, int si, int ei){
        if(si > ei)
            return null;
        int mid = (si + ei) / 2;
        Node node = new Node(arr[mid]);
        node.left = constructTree(arr, si, mid-1);
        node.right = constructTree(arr, mid+1, ei);
        return node;    
    }
    public static Node constructTree(int[] arr){
        return constructTree(arr, 0, arr.length-1);
    }

    public static int size(Node node){
        if(node == null)
            return 0;
        int left = size(node.left); 
        int right = size(node.right);
        return left + right + 1; 
    }

    public static int sum(Node root){
        if(root == null)
            return 0;
        int leftSum = sum(root.left); 
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int height(Node node){
        if(node == null)
            return -1;
        int leftHeight = height(node.left); 
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1; 
    }

    public static int maximum(Node node){
        if(node.right == null)
            return node.data;
        return maximum(node.right);    
    }
    
    public static int minimum(Node node){
        if(node.left == null)
            return node.data;
        return minimum(node.left);    
    }

    public static boolean find(Node node, int data){
        while(node != null){
            if(node.data == data)
                return true;
            else if(node.data > data)
                node = node.left;
            else
                node = node.right;        
        }
        return false;
    }

    public static Node add(Node node, int data) {
        Node curr = node;  
        while(curr.left != null || curr.right != null){
            if(curr.data > data)
                curr = curr.left;
            else
                curr = curr.right;        
        }
        if(curr.data == data)
            return node;
        Node mynode = new Node(data, null, null);
        if(curr.data > data)
            curr.left = mynode;
        else
            curr.right = mynode;
        return node;
    }

    public static int lca(Node node, int d1, int d2) {
        Node curr = node;
        while(curr != null){
            if(curr.data > d1 && curr.data > d2)
                curr = curr.left;
            else if(curr.data < d1 && curr.data < d2)
                curr = curr.right;
            else
                return curr.data;
        }
        return -1;
    }
}
