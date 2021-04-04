class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String ele : words)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b))
                return b.compareTo(a);
            else
                return map.get(a) - map.get(b); 
        });
        for(String e : map.keySet()){
            pq.add(e);
            if(pq.size() > k) pq.remove();
        }
        ArrayList<String> ans = new ArrayList<>();
        while(pq.size() != 0){
            ans.add(pq.remove());
        }
        Collections.sort(ans, (a, b) -> {
            if(map.get(a) == map.get(b))
                return a.compareTo(b);
            else
                return map.get(b) - map.get(a);    
        });
        return ans;
    }
}