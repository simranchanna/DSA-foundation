import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nstar = 1;
    int nspace = (2*n)-3;
    int temp = 1;
    for(int i=0;i<n;i++){
        for(int j=0;j<nstar;j++){
            System.out.print(temp + "\t");
            temp++;
        }
        for(int j=0;j<nspace;j++){
            System.out.print("\t");
        }
        if(i==n-1){
            nstar--;
            temp--;
        }
        for(int j=0;j<nstar;j++){
            temp--;
            System.out.print(temp + "\t");
        }
        System.out.println();
        nstar++;
        nspace-=2;
    }
 }
}