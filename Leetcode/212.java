class Solution {
    public static List<String> ans;

    public static void wordSearch(char[][] board, int[][] dir, int r, int c, String word, int idx){

        char ch = board[r][c];
        if(ch == "A")
            return;
        if(ch == word.charAt(idx)){
            for(int i=0; i<dir.length; i++){
                int row = dir[i][0];
                int col = dir[i][1];
                if(row>=0 && col>=0  && row<board.length && col<board[0].length){
                    
                }
            }
        }    
    }
    public List<String> findWords(char[][] board, String[] words) {
        
    }
}