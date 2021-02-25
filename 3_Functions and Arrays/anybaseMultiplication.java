import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
}

public static int getSum(int b, int n1, int n2){
       int ans=0, carry=0, mult=1;
       while(n1!=0||n2!=0||carry!=0){
           int d1 = n1%10;
           int d2 = n2%10;
           int D = d1+d2+carry;
           if(D>=b){
               carry = D/b;
               D %= b;
           }
           else
               carry = 0;
            ans += D*mult;
            n1 /= 10;
            n2 /= 10;
            mult *= 10;
       }
       return ans;
   }

public static int gpwsd(int b, int n1, int d2){ //get product with single digit
    int ans = 0;
    int carry = 0;
    int pow = 1;
    while(n1!=0 || carry!=0){
        int temp = n1%10;
        int p = temp*d2 + carry;
        int q = p/b;
        int r = p%b;
        ans += r*pow;
        pow *= 10;
        carry = q;
        n1/=10;
    }
    return ans;
}

 public static int getProduct(int b, int n1, int n2){
    int ans=0, pow=1;
       while(n2!=0){
           int temp = n2%10;
           int p = gpwsd(b, n1, temp);
           ans = getSum(b, ans, p*pow);
           pow *=10;
           n2/=10;
       }
       return ans;
 }

}