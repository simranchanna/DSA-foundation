class Solution {
    public static int permute(int[] arr, boolean[] vis, int visited, List<Integer> ans, List<List<Integer>> list){
        if(visited == arr.length){
            //System.out.println(ans);
            List<Integer> base = new ArrayList<>(ans);
            list.add(base);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]){
                vis[i] = true;
                ans.add(arr[i]);
                count += permute(arr, vis, visited+1, ans, list);
                ans.remove(ans.size()-1);
                vis[i] = false;
            }
        }
        return count;
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        permute(nums, vis, 0, ans, list);
        return list;
    }
}