//Order Of Compilation
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
      }

      // visited array
      boolean[] visited = new boolean[vtces];
      
      //stack
      Stack<Integer> stk = new Stack<>();
      
      //vertices pr loop to check connected components
      for(int i = 0 ; i < vtces; i++)
      {
          //unvisited pr call
          if(visited[i] == false)
          {
              //toplogical sort call liya and stk bhi paas kiya
              topologicalSort(graph,i,visited,stk);
              
          }
      }
      
      //functions se bahr aakr jo bhi stack m h print kr diya
      while(stk.size() > 0)
      {
          System.out.println(stk.pop());
      }
      
   }
   
   public static void topologicalSort(ArrayList<Edge>[] graph , int src , boolean[] visited, Stack<Integer> stk)
   {
       //aate hi visited mark
       visited[src] = true;
       
       //nbrs pr loop 
       for(Edge e : graph[src])
       {
           //unvisited nbr ko check kiya
           if(visited[e.nbr] == false)
           {
               //recusive call from nbr
               topologicalSort(graph,e.nbr,visited,stk);
           }
       }
       
       //postorder m statck m add kr liya
       stk.push(src);
       
   }
   
}
