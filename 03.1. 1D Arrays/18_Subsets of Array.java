import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = scn.nextInt();
        }
        
        int limit = (int)Math.pow(2, arr.length); // to know how many subsets
        for(int i = 0; i < limit; i++)
        {
            String set = "";
            int temp = i;
            // Inverse loop bcoz base conversion m reverse print krna hota h
            // so last bit sbse phle aayegi inverse loop se
            for(int j = arr.length - 1 ; j >= 0 ; j--)
            {
                int rem = temp % 2;
                temp = temp / 2;
                
                if(rem == 0)
                {
                    set = "-\t" + set; // print blank
                }
                else
                {
                    set = arr[j] + "\t" + set; // add value
                }
            }
            System.out.println(set);
        }   
    }
}
