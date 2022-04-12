class Main {

  // Tree Node 
  class Node {
    public int val;
    public List<Node> children;
  
    public Node() {
      val = 0;
      children = new ArrayList<Node>();
    }
  
    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }
  
    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  class Query {
    int u; 
    char c; 
    Query(int u, char c) {
      this.u = u; 
      this.c = c;
    }
  }

  
  

  Node searchRootNode(Node root, int k) {
    if(root!=null && root.val == k) {
      return root;
    }
    
    for(Node n : root.children) {
      Node node = searchRootNode(n, k);
      if (node.val == k) return node;
    }
    
    return root;
  } 
  
  int sumOccurrences(Node root, String s, char c, int sum) {
    
    if(s.charAt(root.val-1) == c) {
        sum++;
    }
    
    for(Node n : root.children) {
      sum = sumOccurrences(n, s, c, sum);
    }

    return sum;
  }
  

  int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {

    int[] res = new int[queries.size()];
    for(int i=0; i<queries.size(); i++) {
      Node subroot = searchRootNode(root, queries.get(i).u);
      res[i] = sumOccurrences(subroot, s, queries.get(i).c, 0);
    }
   
    return res;
  }
}