class Solution {
    public int maximumgold(int[][] grid,  int r, int c, boolean[][] vis, int[][] dir){
        if(grid[r][c] == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int maxg = 0;
        vis[r][c] = true;
        for(int i=0; i<dir.length; i++){
            int row = r + dir[i][0];
            int col = c  + dir[i][1];
            if(row>=0 && col>=0 && row<n && col<m && grid[row][col]!=0 && !vis[row][col]){
                maxg = Math.max(maxg, maximumgold(grid, row, col, vis, dir));
            }
        }
        vis[r][c] = false;
        return maxg + grid[r][c];
    }
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int maxGold = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int ans = maximumgold(grid, i, j, vis, dir);
                if(ans > maxGold)
                    maxGold = ans;
            }
        }
        return maxGold;
    }
}