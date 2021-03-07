import java.util.ArrayList;

public class binaryTree {
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    //TRAVERSAL OF BINARY TREE
    public static void preorder(Node root, ArrayList<Integer> ans){
        if(root == null)
            return;
        ans.add(root.data);    
        preorder(root.left,ans);
        preorder(root.right,ans);    
    }

    public static void inorder(Node root, ArrayList<Integer> ans){
        if(root == null)
            return;
        inorder(root.left,ans);
        ans.add(root.data);    
        inorder(root.right,ans);    
    }

    public static void postorder(Node root, ArrayList<Integer> ans){
        if(root == null)
            return;    
        postorder(root.left,ans);
        postorder(root.right,ans); 
        ans.add(root.data);       
    }

    //SIZE OF BINARY TREE
    public static int size(Node root){
        if(root == null)
            return 0;
        int left = size(root.left); 
        int right = size(root.right);
        return left + right + 1;   
    }

    //HEIGHT OF BINARY TREE
    public static int height(Node root){
        if(root == null)
            return -1;
        int leftHeight = height(root.left); 
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;   
    }
    public static int heightInTermsOfNode(Node root){
        if(root == null)
            return 0;
        int leftHeight = heightInTermsOfNode(root.left); 
        int rightHeight = heightInTermsOfNode(root.right);
        return Math.max(leftHeight, rightHeight) + 1;   
    }

    //MAXIMUM OF BINARY TREE
    public static int maximum(Node root){
        if(root == null)
            return Integer.MIN_VALUE;
        int lmax = maximum(root.left); 
        int rmax = maximum(root.right);
        return Math.max(Math.max(lmax, rmax) , root.data);   
    }

    //SUM OF NODES OF BINARY TREE
    public static int sum(Node root){
        if(root == null)
            return 0;
        int leftSum = sum(root.left); 
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static boolean findData(Node root, int data){
        if(root == null)
            return false;
        boolean res = root.data == data;
        return res || findData(root.left, data) || findData(root.right, data);   
    }

}
