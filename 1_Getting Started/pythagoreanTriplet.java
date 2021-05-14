import java.util.*;
  
public class Main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();
        n1 *= n1;
        n2 *= n2;
        n3 *= n3;
        if(n1+n2==n3 || n1+n3==n2 || n2+n3==n1)
            System.out.println(true);
        else    
            System.out.println(false);
    }
}