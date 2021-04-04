import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    public String RLES(String str){  //RUN LENGTH ENCODED STRING
        int[] freq = new int[26];
        for(int i=0; i<str.length(); i++)
            freq[str.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                sb.append((char) (i + 'a'));
                sb.append(freq[i]);
            }
        }    
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            String rles = RLES(s);
            map.putIfAbsent(rles, new ArrayList<String>());
            map.get(rles).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet())
            ans.add(map.get(key));
        return ans;    
    }
}