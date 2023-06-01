import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       // Here n is number and b is base 
       int ans = 0;
       int power = 1; //10^0 = 1 then 10^1 = 10 & so on
       
       while(n != 0){
           int digit = n % b;
           n = n / b;
           
           ans += (digit * power);
           power *= 10;
       }
       
       return ans;
   }
  }