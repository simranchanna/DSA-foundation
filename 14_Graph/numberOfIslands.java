import java.io.*;
import java.util.*;

public class Main {

    public static void dfs_island(int[][] mat, int[][] dir, int i, int j){
        mat[i][j] = 1;
        for(int d=0; d < 4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && mat[r][c]==0)
                dfs_island(mat, dir, r, c);
        }
    }
    public static int numberIsland(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    dfs_island(mat, dir, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }
        System.out.println(numberIsland(arr));

   }

}