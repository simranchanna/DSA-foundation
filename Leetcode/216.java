public class 216 {
    public static int combinationsWithInfi(int target, int k, int idx, List<List<Integer>> list, List<Integer> ans){
        if(k == 0 || target == 0){
            if(target == 0 && k == 0){
                List<Integer> base = new ArrayList<>(ans);
                list.add(base);
                return 1;
            }
            return 0;    
        }
        int count = 0;
        for(int i=idx; i<=9; i++){
            if(target - i >= 0){
                ans.add(i);
                count += combinationsWithInfi(target-i, k-1, i+1, list, ans);
                ans.remove(ans.size()-1);
            }
            else
                break;
        }
        return count;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combinationsWithInfi(n, k, 1, list, ans);
        return list;
    }
}
