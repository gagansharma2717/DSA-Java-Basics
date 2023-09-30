import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // Count Binary Strings - Tabulation - O(n)
    int[] dp0 = new int[n + 1];
    int[] dp1 = new int[n + 1];
    dp0[1] = dp1[1] = 1;
    
    for(int i=2; i<=n; i++)
    {
        dp0[i] = dp1[i - 1]; // adding 0 in previous 1
        dp1[i] = dp0[i - 1] + dp1[i - 1]; // adding 1 in previous 0 and previous 1
    }
    
    System.out.println(dp0[n] + dp1[n]);
    
    // Constant space without dp array
    int prev0 = 1, prev1 = 1;
    for(int i=2; i<=n; i++)
    {
        int curr0 = prev1;
        int curr1 = prev0 + prev1;
        prev0 = curr0; prev1 = curr1;
    }

    System.out.println(prev0 + prev1);
    
  }

}
