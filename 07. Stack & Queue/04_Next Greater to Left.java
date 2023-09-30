import java.io.*;
import java.util.*;

public class Main {
  
  public static int[] solve(int[] arr) {
    int n = arr.length;
    int[] nge = new int[n];
    
    Stack<Integer> stk = new Stack<>();
    for(int i=0; i<n; i++){
        
        // Pop Smaller Elements
        while(stk.size() > 0 && stk.peek() < arr[i]){
            stk.pop();
        }
        
        // Answer -> Stack's top
        if(stk.size() == 0){
            nge[i] = -1;
        } else {
            nge[i] = stk.peek();
        }
        
        // Push Yourself
        stk.push(arr[i]);
    }
    
    return nge;
  }

}
