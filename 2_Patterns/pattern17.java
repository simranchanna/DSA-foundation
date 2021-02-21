import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = 1;
        int nstar = 1;
        int nspace = n/2;
        while(row<=n){
            if(row == (n/2)+1){
                for(int i=0;i<n;i++){
                    System.out.print("*\t");
                }
            }
            else{
                for(int i=0;i<nspace;i++){
                    System.out.print("\t");
                }
                for(int i=0;i<nstar;i++){
                    System.out.print("*\t");
                }
            }
            System.out.println();
            if(row<=n/2){
                nstar++;
            }
            else{
                nstar--;
            }
            row++;
        }
    }
}