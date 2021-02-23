import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getDifference(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getDifference(int b, int n1, int n2){
       int ans=0, borrow=0, mult=1;
       while(n2!=0){
           int d1 = n1%10;
           int d2 = n2%10;
           int D = d2-d1-borrow;
           if(D<0){
               borrow = 1;
               D += b;
           }
           else
               borrow = 0;
            ans += D*mult;
            n1 /= 10;
            n2 /= 10;
            mult *= 10;
       }
       return ans;
   }
  
  }