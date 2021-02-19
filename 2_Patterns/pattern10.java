import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int nstar = 1;
    int nspace = n/2;
    for(int i=0;i<n;i++){
        for(int j=0;j<nspace;j++){
            System.out.print("\t");
        }
        for(int j=0;j<nstar;j++){
            if(j==0||j==nstar-1)
                System.out.print("*\t");
            else
                System.out.print("\t");
        }
        System.out.println();
        if(i<n/2){
            nspace--;
            nstar+=2;
        }
        else{
            nspace++;
            nstar-=2;
        }
    }
 }
}