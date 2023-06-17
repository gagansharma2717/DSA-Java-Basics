import java.util.Scanner;

public class Test {
    public static int factorial(int n){
        int fact = 1;
        for (int i = 1;  i <= n ; i++){
            fact *= i ;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        /*
        int nfact = 1;
        for(int i = 1; i <= n ; i++){
            nfact *= i;
        }

        int nmrfact = 1;
        for(int i = 1; i <= n-r ; i++){
            nmrfact *= i;
        }
        */

        int npr = factorial(n) / factorial(n-r);

        System.out.println("Permutation of " + n + " and " + r + " is : " + npr );
    }
}

// Recursive
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int f = factorial(n);
    System.out.println(f);
  }

  public static int factorial(int n) {
    if(n == 0){
      return 1;
    }
    int fm1 = factorial(n - 1);
    int f = fm1 * n;
    return f;
  }

}