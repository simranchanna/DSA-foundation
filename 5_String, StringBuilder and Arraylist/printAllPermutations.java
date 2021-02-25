import java.io.*;
import java.util.*;

public class Main {
    
    public static int fact(int n){
        if(n==1 || n==0)
            return n;
        return n*fact(n-1);    
    }
	public static void solution(String str){
		int n = str.length();
		int fact = fact(n);
		for(int i=0; i<fact; i++){
		    StringBuilder sb = new StringBuilder(str);
		    int temp = i;
		    for(int j=n; j>0; j--){
		        int q = temp / j;
		        int r = temp % j;
		        System.out.print(sb.charAt(r));
		        sb.deleteCharAt(r);
		        temp = q;
		    }
		    System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}