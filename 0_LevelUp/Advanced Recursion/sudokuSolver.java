class Solution {
    public boolean isSafeToPlaceNumber(char[][] board, int row, int col, int num){
        //row
        for(int j=0; j<9; j++){
            if((board[row][j] - '0') == num)
                return false;
        }
        //col
        for(int i=0; i<9; i++){
            if((board[i][col] - '0') == num)
                return false;
        }
        //matrix
        int r = (row / 3) * 3;
        int c = (col / 3) * 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((board[i+r][j+c] - '0') == num)
                    return false;
            }
        }
        return true;
    }
    public boolean sudokuSolver(char[][] board, int idx){
        if(idx == 81){
            return true;
        }
        int r = idx / 9;
        int c = idx % 9;
        if(board[r][c] != '.'){
            if(sudokuSolver(board, idx+1)) return true;
        }
        else{
            for(int i=1; i<=9; i++){
                if(isSafeToPlaceNumber(board, r, c, i)){
                    board[r][c] = (char)(i + '0');
                    if(sudokuSolver(board, idx+1)) return true;
                    board[r][c] = '.';
                }
            }  
        }    
        return false;  
    }
    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0);
    }
}