import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        // First Array
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0; i<n1; i++)
            arr1[i] = scn.nextInt();
        
        // Second Array
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0; i<n2; i++)
            arr2[i] = scn.nextInt();
        
        // Resultant Array
        int n3 = Math.max(n1, n2) + 1;
        // + 1 for carry value
        int[] arr3 = new int[n3];
        
        int carry = 0;
        int i = arr1.length - 1, j = arr2.length - 1, k = arr3.length - 1;

        while(k >= 0)// condition
        { 
            int dig1 = (i >= 0) ? arr1[i] : 0;
            int dig2 = (j >= 0) ? arr2[j] : 0;
            int sum = dig1 + dig2 + carry;
            int quot = sum / 10;
            int rem = sum % 10;
            
            arr3[k] = rem;
            carry = quot;
            i--; j--; k--;
        }
        
        for(int i=0; i<arr3.length; i++)
        {   
            // if 1st index has value 0 then continue
            // if carry place value is 0 then continue
            if(i == 0 && arr3[i] == 0)
                continue;
            else
                System.out.println(arr3[i]);
        }
    }
}