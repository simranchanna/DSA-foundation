import java.io.*;
import java.util.*;

public class Main {
    
    public static void placeH(char[][] arr, int r, int c, String word){
        for(int i=0; i<word.length(); i++){
            arr[r][c] = word.charAt(i);
            c++;
        }
    }
    public static void unplaceH(char[][] arr, int r, int c, String word){
        for(int i=0; i<word.length(); i++){
            arr[r][c] = '-';
            c++;
        }
    }
    public static void placeV(char[][] arr, int r, int c, String word){
        for(int i=0; i<word.length(); i++){
            arr[r][c] = word.charAt(i);
            r++;
        }
    }
    public static void unplaceV(char[][] arr, int r, int c, String word){
        for(int i=0; i<word.length(); i++){
            arr[r][c] = '-';
            r++;
        }
    }

	public static void solution(char[][] arr, String[] words, int vidx){
		//write your code here

	}

	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}

	}
}