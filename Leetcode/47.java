class Solution {
    public static int permute(int[] arr, int visited, List<Integer> ans, List<List<Integer>> list){
        if(visited == arr.length){
            //System.out.println(ans);
            List<Integer> base = new ArrayList<>(ans);
            list.add(base);
            return 1;
        }
        int count = 0;
        int prev = -12;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11 && prev != arr[i]){
                int val = arr[i];
                arr[i] = -11;
                ans.add(val);
                count += permute(arr, visited+1, ans, list);
                ans.remove(ans.size()-1);
                arr[i] = val;
                prev = arr[i];
            }
        }
        return count;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        permute(nums, 0, ans, list);
        return list;
    }
}