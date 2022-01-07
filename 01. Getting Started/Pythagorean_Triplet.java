import java.util.*;

public class Main {

  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int a = scn.nextInt();
    int b = scn.nextInt();
    int c = scn.nextInt();
    int max = a;

    if ( max < b )
      max = b;
    if (max < c)
      max = c;

    if (max == a)
    {
      boolean flag = (a * a) == ((c * c) + (b * b));
      System.out.println(flag);
    }
    else if (max == b)
    {
      boolean flag = (b * b) == ((a * a) + (c * c));
      System.out.println(flag);
    }
    else
    {
      boolean flag = (c * c) == ((a * a) + (b * b));
      System.out.println(flag);
    }

  }
}
