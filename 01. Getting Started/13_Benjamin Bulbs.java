import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner scn = new Scanner(System.in);
    int num = scn.nextInt();
    
    for(int i = 1 ; i * i < num ; i++)
    {
        System.out.println(i*i);
    }
   }
  }
