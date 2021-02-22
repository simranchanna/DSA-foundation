import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=0;i<n;i++){
            if(i<n/2){
                for(int j=0;j<n;j++){
                    if(j==0 || j==n-1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
            }
            else{
                for(int j=0;j<n;j++){
                    if(j==0 || j==i || i+j==n-1 || j==n-1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}