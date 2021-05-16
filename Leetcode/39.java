class Solution {
    public static int combinationsWithInfi(int[] arr, int target, int idx, List<List<Integer>> list, List<Integer> ans){
        if(target == 0){
            List<Integer> base = new ArrayList<>(ans);
            list.add(base);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<arr.length; i++){
            if(target - arr[i] >= 0){
                ans.add(arr[i]);
                count += combinationsWithInfi(arr, target - arr[i], i, list, ans);
                ans.remove(ans.size()-1);
            }
        }
        return count;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combinationsWithInfi(candidates, target, 0, list, ans);
        return list;
    }
}