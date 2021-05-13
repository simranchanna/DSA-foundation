import java.util.ArrayList;

// m is the given matrix and n is the order of matrix
class Solution {

    public ArrayList<String> path(int[][] m, int n, int r, int c, boolean[][] vis, int[][] dir, String[] Sdir, String psf){
        ArrayList<String> ans = new ArrayList<>();
        if(r == n-1 && c == n-1){
            ans.add(psf);
            return ans;
        }
        vis[r][c] = true;
        for(int i=0; i<dir.length; i++){
            int row = r + dir[i][0];
            int col = c  + dir[i][1];
            String s = Sdir[i];
            if(row>=0 && col>=0 && row<n && col<n && m[row][col]!=0 && !vis[row][col]){
                ArrayList<String> p = path(m, n, row, col, vis, dir, Sdir, psf + s);
                while(p.size() != 0){
                    ans.add(p.remove(p.size()-1));
                }
            }
        }
        return ans;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] vis = new boolean[n][n];
        int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        String[] Sdir = {"U", "R", "D", "L"};
        ArrayList<String> ans = new ArrayList<>();
        if(ans.size() == 0)
            System.out.println(-1);
        return ans;    
    }
}