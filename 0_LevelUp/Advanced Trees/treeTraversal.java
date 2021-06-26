import java.util.ArrayList;

public class treeTraversal{
    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    //MORRIS TRAVERSAL
    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr){
        while(node.right != null && node.right != curr){
            node = node.right;
        }
        return node;
    }
    public static ArrayList<Integer> morrisTraversal(TreeNode root){ //inorder
        TreeNode curr = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null){ //thread creation area
                    rightMostNode.right = curr; //thread is created
                    curr = curr.left;
                }
                else{ //thread destroy area
                    rightMostNode.right = null; //thread break
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    public static boolean isBST(TreeNode root){
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                if(prev == null)
                    prev = new TreeNode(curr.val);
                else if(prev.val < curr.val)
                    prev.val = curr.val;
                else
                    return false;
                curr = curr.right;    
            }
            else{
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
                else{
                    rightMostNode.right = null;
                    if(prev == null)
                        prev = new TreeNode(curr.val);
                    else if(prev.val < curr.val)
                        prev.val = curr.val;
                    else
                        return false;
                    curr = curr.right;
                }
            }

        }
        return true;
    }

    // public static void main(String[] args){
    //     isBST(null);
    // }
}