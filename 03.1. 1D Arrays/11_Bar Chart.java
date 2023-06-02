import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<=n-1; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            if(arr[i] > max) 
                max = arr[i]; 
        }
        
        // rows - floor
        for(int floor=max; floor >= 1;   floor--)
        {
            // cols - building
            for(int j=0; j<arr.length; j++)
            {
                if(arr[j] >= floor) // condition
                    System.out.print("*\t"); 
                else 
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
}