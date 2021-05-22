import java.util.ArrayList;

public class nQueens {
    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c){
        int[][] dir = {{0,-1}, {-1,-1}, {-1,0}, {-1,1}};
        int n = boxes.length, m = boxes[0].length;
        for(int d=0; d<dir.length; d++){
            for(int rad=1; rad<n; rad++){
                int x = r + rad * dir[d][0];
                int y = c + rad * dir[d][1];
                if(x>=0 && y>=0 && x<n && y<m){
                    if(boxes[x][y])
                        return false;
                }
                else
                    break;
            }
        }
        return true;
    }
    public static int nQueen_2D(boolean[][] boxes, int tnq, int idx, String ans){
        if(tnq == 0){
            System.out.println(ans);
            return 1;
        }
        int n = boxes.length, m = boxes[0].length, count = 0;
        for(int i=idx; i<n*m; i++){
            int r = i / m;
            int c = i % m;
            if(isSafeToPlaceQueen(boxes, r, c)){
                boxes[r][c] = true;
                count += nQueen_2D(boxes, tnq-1, i+1, ans + "(" + r + "," + c + ")");
                boxes[r][c] = false;
            }
        }
        return count;        
    }
    // static boolean[] row;
    // static boolean[] col;
    // static boolean[] diag;
    // static boolean[] adiag;
    // public static int nQueen_2D_opti(int n, int m, int tnq, int idx, String ans){
    //     if(tnq == 0){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int i=idx; i<n*m; i++){
    //         int r = i / m;
    //         int c = i % m;
    //         if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+m-1]){
    //             row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
    //             count += nQueen_2D_opti(n, m, tnq-1, i+1, ans + "(" + r + "," + c + ")");
    //             row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;
    //         }
    //     }
    //     return count;        
    // }
    public static void main(String[] args){
        boolean[][] boxes = new boolean[4][4];
        nQueen_2D(boxes, 4, 0, "");
        row = new boolean[4];
        col = new boolean[4];
        diag = new boolean[7];
        adiag = new boolean[7];
        System.out.println( nQueen_2D_opti(4, 4, 4, 0, "") );
    }

    // //LEETCODE 52
    // static boolean[] row;
    // static boolean[] col;
    // static boolean[] diag;
    // static boolean[] adiag;
    // public static int nQueen_2D_opti(int n, int tnq, int idx){
    //     if(tnq == 0){
    //         return 1;
    //     }
    //     int count = 0;
    //     for(int i=idx; i<n*n; i++){
    //         int r = i / n;
    //         int c = i % n;
    //         if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+n-1]){
    //             row[r] = col[c] = diag[r+c] = adiag[r-c+n-1] = true;
    //             count += nQueen_2D_opti(n, tnq-1, i+1);
    //             row[r] = col[c] = diag[r+c] = adiag[r-c+n-1] = false;
    //         }
    //     }
    //     return count;        
    // }
    // public int totalNQueens(int n) {
    //     row = new boolean[n];
    //     col = new boolean[n];
    //     diag = new boolean[2*n-1];
    //     adiag = new boolean[2*n-1];
    //     return nQueen_2D_opti(n, n, 0);
    // }

    //LEETCODE 51
    static boolean[] row;
    static boolean[] col;
    static boolean[] diag;
    static boolean[] adiag;
    static List<List<String>> ans;
    public static int nQueen_2D_opti(int n, int tnq, int idx, List<String> list, String dots){
        if(tnq == 0){
            List<String> base = new ArrayList<>(list);
            ans.add(base);
            return 1;
        }
        int count = 0;
        for(int i=idx; i<n*n; i++){
            int r = i / n;
            int c = i % n;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+n-1]){
                row[r] = col[c] = diag[r+c] = adiag[r-c+n-1] = true;
                String s = "";
                for(int j=0; j<n; j++){
                    if(j==c)
                        s = s + "Q";
                    else
                        s = s + ".";    
                }
                list.set(r, s);
                count += nQueen_2D_opti(n, tnq-1, i+1, list, dots);
                list.set(r, dots);
                row[r] = col[c] = diag[r+c] = adiag[r-c+n-1] = false;
            }
        }
        return count;        
    }
    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[2*n-1];
        adiag = new boolean[2*n-1];
        List<String> list = new ArrayList<>();
        ans = new ArrayList<>();
        String s = "";
        for(int i=0; i<n; i++){
            s = s + ".";
        }
        for(int i=0; i<n; i++){
            list.add(s);
        }
        nQueen_2D_opti(n, n, 0, list, s);
        return ans;
    }
}
