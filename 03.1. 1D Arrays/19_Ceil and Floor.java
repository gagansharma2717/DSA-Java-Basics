import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        int num = scn.nextInt();

        int ceil = 0, floor = 0;

        int lo = 0 , hi = arr.length-1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(arr[mid] == num){
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
            else if(arr[mid] > num){
                hi = mid - 1;
                ceil = arr[mid];
            }
            else{
                low = mid + 1;
                floor = arr[mid];
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}