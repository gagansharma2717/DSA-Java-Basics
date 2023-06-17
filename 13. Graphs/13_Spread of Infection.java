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
   
   public static class Pair
   {
       int v;
       int time;
       
       Pair(int v , int time)
       {
           this.v = v;
           this.time = time;
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
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      //bfs ka variation
      int[] visited = new int[vtces];
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src,1));
      int count = 0;
      while(q.size() > 0)
      {
          Pair rem = q.removeFirst();
          //int array m sb 0 h so time 0 se jyada h toh phle visited h so continue
          if(visited[rem.v] > 0)
          {
             continue; 
          }
          //Nhi toh time daal diya visited array m
          visited[rem.v] = rem.time;
          if(rem.time > t)
          {
              //check kiya kya ye time given tgime se jyada h jyada h toh break
              break;
          }
          //count bdaya
          count++;
          
          //nbr add kiye
          for(Edge e : graph[rem.v])
          {
              if(visited[e.nbr] == 0)
              {
                  q.add(new Pair(e.nbr,rem.time + 1));
              }
          }
      }
      
      System.out.println(count);
      
      
      
      
      
      
   }

}
