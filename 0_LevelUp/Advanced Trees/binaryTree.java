import java.util.ArrayList;

public class binaryTree {
    public static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int maximum(TreeNode root) {
        return root == null ? -(int) 1e9 : Math.max(Math.max(Maximum(root.left), Maximum(root.right)), root.val);
    }

    public static boolean find(TreeNode root, int data) {
        if (root == null)
            return false;              
        if (root.val == data)
            return true;
        return find(root.left, data) || find(root.right, data);
    }

    public static ArrayList<TreeNode> NodeToRootPath(TreeNode root, int data) {
        if(root == null) 
            return new ArrayList<>();
        if(root.val == data){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }
        ArrayList<TreeNode> leftList = NodeToRootPath(root.left, data);
        if(leftList.size() != 0){
            leftList.add(root);
            return leftList;
        }
        ArrayList<TreeNode> rightList = NodeToRootPath(root.right, data);
        if(rightList.size() != 0){
            rightList.add(root);
            return rightList;
        }
        return leftList;    
    }

    public static boolean NodeToRootPath(TreeNode root, int data, ArrayList<TreeNode> ans) {
        if(root == null) return false;
        if(root.val == data){
            ans.add(root);
            return true;
        }
        boolean flag = NodeToRootPath(root.left, data, ans) || NodeToRootPath(root.right, data, ans);
        if(flag)
            ans.add(root);
        return flag;       
    }

    public static void nodeToAllLeafPathHelper(TreeNode node,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> smallans){
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            ArrayList<Integer> base=new ArrayList<>(smallans);
            base.add(node.val);
            ans.add(base);
            return;
        }
        smallans.add(node.val);
        nodeToAllLeafPathHelper(node.left, ans, smallans);
        nodeToAllLeafPathHelper(node.right, ans, smallans);
        smallans.remove(smallans.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> nodeToAllLeafPath(TreeNode root) {
      ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
      ArrayList<Integer> smallans=new ArrayList<>();
      nodeToAllLeafPathHelper(root,ans,smallans);
      return ans;
   }

    public static void exactlyOneChild(TreeNode root, ArrayList<Integer> nodes){
        if(root == null || (root.left == null && root.right == null))
            return;
        if(root.left == null || root.right == null)
            nodes.add(root.val);
        exactlyOneChild(root.left, nodes);  
        exactlyOneChild(root.right, nodes);   
    }
    public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        exactlyOneChild(root, ans);
        return ans;
    }

    public static int countExactlyOneChild(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return 0;
        boolean singleChildParent = (root.left == null) || (root.right == null);
        if(singleChildParent)
            return countExactlyOneChild(root.left) + countExactlyOneChild(root.right) + 1;
        return countExactlyOneChild(root.left) + countExactlyOneChild(root.right);        
    }

    //leetcode 863
    public void kDown(TreeNode root, TreeNode blockNode, int k, List<Integer> ans){
        if(root == null || root == blockNode || k < 0){
            return;
        }
        if(k == 0){
            ans.add(root.val);
            return;
        }
        kDown(root.left, blockNode, k-1, ans);
        kDown(root.right, blockNode, k-1, ans);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ArrayList<TreeNode> path = new ArrayList<>();
        NodeToRootPath(root, target.val, path);
        List<Integer> ans = new ArrayList<>();
        TreeNode blockNode = null;
        for (int i = 0; i < path.size(); i++) {
            if (K - i < 0)
                break;
            kDown(path.get(i), blockNode, K - i, ans);
            blockNode = path.get(i);
        }
        return ans;
    }
}
