class Solution {
    public static int letterCasePermutation(String s, int idx, String asf, List<String> list){
        if(idx == s.length()){
            list.add(asf);
            return 1;
        }
        int count = 0;
        char ch = s.charAt(idx);
        count += letterCasePermutation(s, idx+1, asf + ch, list);
        if(ch >= 'a' && ch <= 'z'){
            char temp = (char)('A' + (ch - 'a'));
            count += letterCasePermutation(s, idx+1, asf + temp, list);
        }
        else if(ch >= 'A' && ch <= 'Z'){
            char temp = (char)('a' + (ch - 'A'));
            count += letterCasePermutation(s, idx+1, asf + temp, list);
        }
        return count;
    }
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        letterCasePermutation(s, 0, "", list);
        return list;
    }
}