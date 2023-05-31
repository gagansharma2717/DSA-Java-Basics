public static int size(Node root{
  if(root == null) return 0;

  int total_size = 0 ;

  // Expectation is root ke saare children pr loop lgao vo apna size bta denge usko totalsize m add krlo
  for(Node child : root.children){
      int childsize = size(child);
      total_size += childsize;
  }

  // then root ka khud size bhi add krlo taht will be our total size
  // Meeting Expectation with faith
  total_size += 1;

  return total_size;
}

 public static int max(Node root){
        // Initially assumed root data as max
        int max = root.data;

        // Run loop on root children's get children's max and compare it with Max and update the max
        for(Node child : root.children){
            int cmax = max(child);
            max = Math.max(cmax, max);
        }

        
        return max;
    }

public static int heightByNodes(Node root) {
  // in terms of nodes
  int height = 0;

  for (Node child : root.children) {
    height = Math.max(height, heightByNodes(child));
  }

  return height + 1;
}

public static int heightByEdges(Node root) {
  // in terms of edges

  int ans = 0;

  for (Node child : root.children) {
    ans = Math.max(ans, heightByEdges(child) + 1);
  }

  return ans;
}


public static int height(Node root) {
  // in terms of edges

  // return heightByEdges(root);

  if (root == null) return 0;

  int ans = heightByNodes(root);
  return ans - 1;

}
