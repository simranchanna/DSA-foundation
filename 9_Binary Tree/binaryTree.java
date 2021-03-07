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
            return 0;
        int leftHeight = size(root.left); 
        int rightHeight = size(root.right);
        return Math.max(leftHeight, rightHeight) + 1;   
    }

}
