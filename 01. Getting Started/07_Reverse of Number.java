import java.util.*;
   
   public class Main{
   
   public static void main(String[] args) {
     // write your code here 
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      
      while(n > 0)
      {
        System.out.println(n % 10); // Remainder
        n = n / 10; // Quotient

        //  e.g 
        //  745 / 10 = 74 -> Quotient
        //  745 % 10 = 5 -> Remainder
        
      }
    }
   }
