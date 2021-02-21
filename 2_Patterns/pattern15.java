import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = 1;
        int nstar = 1;
        int nspace = n/2;
        int x = 1;
        while(row<=n){
            int y = x;
            for(int i=0;i<nspace;i++){
                System.out.print("\t");
            }
            for(int i=0;i<nstar;i++){
                System.out.print(y + "\t");
                if(i<nstar/2)
                    y++;
                else
                    y--;
            }
            System.out.println();
            if(row<=n/2){
                nstar+=2;
                nspace--;
                x++;
            }
            else{
                nstar-=2;;
                nspace++;
                x--;
            }
            row++;
        }
    }
}