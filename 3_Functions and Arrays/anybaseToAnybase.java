import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
      int  destBase= scn.nextInt();
      int temp = getValueIndecimal(n,sourceBase);
      int ans = getValueInBase(temp,destBase);
      System.out.println(ans);
   }   
  public static int getValueIndecimal(int n, int b){
      int pow = 1,ans = 0;
       while(n!=0){
           int rem = n%10;
           ans += pow*rem;
           pow *= b;
           n /= 10;
       }
       return ans;
   }
   public static int getValueInBase(int n, int b){
       int pow = 1,ans = 0;
       while(n!=0){
           int rem = n%b;
           ans += pow*rem;
           pow *= 10;
           n /= b;
       }
       return ans;
   }
  }