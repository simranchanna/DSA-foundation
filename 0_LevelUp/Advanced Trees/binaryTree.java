import java.util.ArrayList;
import java.util.LinkedList;

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

    //leetcode 236
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = NodeToRootPath(root, p.val);
        ArrayList<TreeNode> list2 = NodeToRootPath(root, q.val);
        TreeNode ans = null;
        if(list1.contains(q))
            return q;
        if(list2.contains(p))
            return p;
        for(int i=1; i<list1.size(); i++){
            TreeNode x = list1.get(i);
            for(int j=1; j<list2.size(); j++){
                TreeNode y = list2.get(j);
                if(x == y){
                    ans = x;
                    return ans;
                }
            }
        }
        return ans;
    }

    //levelorder traversal
    public static ArrayList<ArrayList<Integer>> levelorder(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null)  return ans;
        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                smallAns.add(rnode.val);
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
            ans.add(smallAns);
        }
        return ans;
    }

    public static ArrayList<Integer> leftView(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)  return ans;
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> rightView(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)  return ans;
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getLast().val);
            while(size-->0){
                TreeNode rnode = que.removeFirst();
                if(rnode.left != null)
                    que.addLast(rnode.left);
                if(rnode.right != null)
                    que.addLast(rnode.right);
            }
        }
        return ans;
    }

    public static void widthOfShadow(TreeNode root,int vl, int[] minMax){
        if(root == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);   
        widthOfShadow(root.left, vl-1, minMax);
        widthOfShadow(root.right, vl+1, minMax); 
    }

    //vertical order traversal
    public class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root){
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minMax[0])));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<length; i++){
            ans.add(new ArrayList<>());
        }
        while(que.size() != 0){
            int size = que.size();
            while(size-->0){
                vPair rPair = que.removeFirst();
                ans.get(rPair.vl).add(rPair.node.val);;
                if(rPair.node.left != null)
                    que.addLast(new vPair(rPair.node.left, rPair.vl-1));
                if(rPair.node.right != null)
                    que.addLast(new vPair(rPair.node.right, rPair.vl+1));
            }
        }
        return ans;
    }
    public static ArrayList<Integer> bottomView(TreeNode root){
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minMax[0])));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<length; i++){
            ans.add(0);
        }
        while(que.size() != 0){
            int size = que.size();
            while(size-->0){
                vPair rPair = que.removeFirst();
                ans.set(rPair.vl, rPair.node.val);
                if(rPair.node.left != null)
                    que.addLast(new vPair(rPair.node.left, rPair.vl-1));
                if(rPair.node.right != null)
                    que.addLast(new vPair(rPair.node.right, rPair.vl+1));
            }
        }
        return ans;
    }
    public static ArrayList<Integer> topView(TreeNode root){
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
        LinkedList<vPair> que = new LinkedList<>();
        que.addLast(new vPair(root, Math.abs(minMax[0])));
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<length; i++){
            ans.add(null);
        }
        while(que.size() != 0){
            int size = que.size();
            while(size-->0){
                vPair rPair = que.removeFirst();
                if(ans.get(rPair.vl) == null)
                    ans.set(rPair.vl, rPair.node.val);
                if(rPair.node.left != null)
                    que.addLast(new vPair(rPair.node.left, rPair.vl-1));
                if(rPair.node.right != null)
                    que.addLast(new vPair(rPair.node.right, rPair.vl+1));
            }
        }
        return ans;
    }
}
