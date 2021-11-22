import java.io.*;
import java.util.*;

public class Main {
   
   public static class Edge{
       int vertex;
       int nbr;
       
        Edge(int vertex,int nbr)
        {
            this.vertex = vertex;
            this.nbr = nbr ;
        }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      //Array created of blank arraylist 
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int v = 0 ; v < n ; v++)
      {
          graph[v] = new ArrayList<>();
      }
      
      //Implementing Adjacency list
      for(int i = 0 ; i < k ; i++)
      {
          // reading a whole line
          String line = br.readLine();
          // spliting that line on basis of space and storing it in string array
          String[] parts = line.split(" ");
          
          //adding value of parrs[0] in v1 and parts[1] in  v2
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          
          //adding edges in arraylist
          
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      
      boolean[] visited = new boolean[n];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      for(int j = 0 ; j < n; j++)
      {
          if(visited[j] == false)
          {
            ArrayList<Integer> comp = new ArrayList<>();
            dfs(graph,j,comp,visited);
            comps.add(comp);
          }
      }
      
      int pairs = 0;
      
      //Components arraylist pr loop bcoz usme components honge and hm unka size multiply krke aapna answer bna lenge
      for(int i = 0 ; i < comps.size(); i++)
      {
          for(int j = i  + 1 ; j < comps.size(); j++)
          {
              int count = comps.get(i).size() * comps.get(j).size();
              
              pairs += count;
          }
      }
      
      System.out.println(pairs);
     
   }
   
   public static void dfs(ArrayList<Edge>[] graph, int src , ArrayList<Integer> comp, boolean[] visited)
   {
       
       visited[src] = true;
       comp.add(src);
       
       for(Edge e : graph[src])
       {
           if(visited[e.nbr] == false)
           {
            
                 dfs(graph,e.nbr,comp,visited);
           }
       }
       
       
   }

}
