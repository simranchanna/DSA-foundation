class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        for(Integer e : map.keySet()){
            pq.add(e);
            if(pq.size() > k) pq.remove();
        }

        int[] ans = new int[k];
        int idx = 0;
        while(pq.size() != 0){
            ans[idx++] = pq.remove();
        }

        return ans;
    }
}