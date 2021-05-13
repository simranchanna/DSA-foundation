import java.io.*;
import java.util.*;

public class floodfill {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int maze[][] = new int[n][m];
        boolean visited[][] = new boolean[n][m]; //by default false
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scn.nextInt();
            }
        }
        int[][] dir = {{-1,-1}, {}, {}, {}, {}, {}, {}, {}};
        char[] moves = {'t', 'e', 'r', 's', 'd', 'w', 'l', 'n'};
        floodfill(maze, 0, 0, "", visited, moves);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited, char[] moves) {
        int n = maze.length;
        int m = maze[0].length;
        //base case
        if (row == n - 1 && col == m - 1) {
            System.out.println(psf);
            return;
        }

        visited[row][col] = true;
        for(int i=0; i<moves.length)
        //top move
        if (row > 0) {
            if (!visited[row - 1][col] && maze[row - 1][col] == 0) {
                floodfill(maze, row - 1, col, psf + "t", visited);
            }
        }
        //left move
        if (col > 0) {
            if (!visited[row][col - 1] && maze[row][col - 1] == 0) {
                floodfill(maze, row, col - 1, psf + "l", visited);
            }
        }
        //down move
        if (row < n - 1) {
            if (!visited[row + 1][col] && maze[row + 1][col] == 0) {
                floodfill(maze, row + 1, col, psf + "d", visited);
            }
        }
        //right move
        if (col < m - 1) {
            if (!visited[row][col + 1] && maze[row][col + 1] == 0) {
                floodfill(maze, row, col + 1, psf + "r", visited);
            }
        }
        //north move
        if (row > 0) {
            if (!visited[row - 1][col] && maze[row - 1][col] == 0) {
                floodfill(maze, row - 1, col, psf + "t", visited);
            }
        }
        // move
        if (col > 0) {
            if (!visited[row][col - 1] && maze[row][col - 1] == 0) {
                floodfill(maze, row, col - 1, psf + "l", visited);
            }
        }
        // move
        if (row < n - 1) {
            if (!visited[row + 1][col] && maze[row + 1][col] == 0) {
                floodfill(maze, row + 1, col, psf + "d", visited);
            }
        }
        //right move
        if (col < m - 1) {
            if (!visited[row][col + 1] && maze[row][col + 1] == 0) {
                floodfill(maze, row, col + 1, psf + "r", visited);
            }
        }
        visited[row][col] = false;
    }
}