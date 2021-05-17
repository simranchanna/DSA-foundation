
class Solution {
    public static int combine(int n, int k, int idx, List<Integer> ans, List<List<Integer>> list){
        if(k == 0){
            List<Integer> base = new ArrayList<>(ans);
            list.add(base);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<=n; i++){
            ans.add(i);
            count += combine(n, k-1, i+1, ans, list);
            ans.remove(ans.size()-1);
        }
        return count;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combine(n, k, 1, ans, list);
        return list;
    }
}