//Minimum Wire Required To Connect All Pcs
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
    static class Pair implements Comparable<Pair>
    {
        //implemements Comparable m type bhi btana pdta h
        //vertex --> v
        // acquiring vertex --> av
        //wt --> weight
        int v;
        int av;
        int wt;
        
        Pair(int v , int av , int wt)
        {
            this.v = v;
            this.av =av;
            this.wt=wt;
        }
        
        public int compareTo(Pair others)
        {
            return this.wt - others.wt;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
        
 
      //visited array 
      boolean[] visited = new boolean[vtces];
      
      //priority queue
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      //adding 0 as src and -1 as acquiring vertex and 0 as wt
      pq.add(new Pair(0,-1,0));
      
      while(pq.size() > 0)
      {
          // remove
          Pair rem = pq.remove();
          
          //mark *
          if(visited[rem.v] == true)
          {
              continue;
          }
          visited[rem.v] = true;
          
          // Work --> if acquired vertex is not equal to -1 then print kre basically phla pair from pq print nhi krna h
          if(rem.av != -1){
          System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
          }
          
          
          //add* ->  adding neighbours just difference ye h pair m  acquiring vertex m pichla vertex that is rem.v add krenge and baaki e.nbr --> taht is nbr vertex aNd nbr wt --> nbr.wt
          for(Edge e : graph[rem.v])
          {
              if(visited[e.nbr] == false)
              {
                  pq.add(new Pair(e.nbr,rem.v,e.wt));
              }
          }
             
      }
   }

}
