import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = 0, y = 1;
        int z = x + y;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(x + "\t");
                x = y;
                y = z;
                z = x + y;
            }
            System.out.println();
        }
    }
}
//pattern for n=5
// 0	
// 1	1	
// 2	3	5	
// 8	13	21	34	
// 55	89	144	233	377