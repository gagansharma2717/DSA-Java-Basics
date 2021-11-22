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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      //Hashmap ki keys are hashset 0(1)
      HashSet<Integer> visited = new HashSet<>();
      
      hamiltonion(graph,src,visited,src+ "" ,src);
   }

    public static void hamiltonion(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int orgsrc)
    {
        // Minus 1 isliye bcoz jb hmne call lgayi psf m hm src add krte aate h and visited blank paas hota h vo function m andar aane k baad add krta h so -1 krna pdega
        if(visited.size() == graph.length- 1)
        {
            //closing edge means cycle 
            boolean closingEdgefound = false;
            for(Edge e : graph[src])
            {
                if(e.nbr == orgsrc)
                {
                    closingEdgefound = true;
                    break;
                }
            }
            
            if(closingEdgefound == true)
            {
                System.out.println(psf + "*");
            }
            else
            {
                System.out.println(psf + ".");
            }
        }
        visited.add(src);
        
        for(Edge e : graph[src])
        {
            if(visited.contains(e.nbr) == false)
            {
                hamiltonion(graph,e.nbr,visited,psf+e.nbr,orgsrc);
            }
            
        }
        
        visited.remove(src);
    }
}
