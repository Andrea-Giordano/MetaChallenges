class Main {

  class Node {
    int data; 
    Node left; 
    Node right; 
    Node() {
      this.data = 0; 
      this.left = null; 
      this.right = null; 
    }
    Node(int data) {
      this.data = data; 
      this.left = null; 
      this.right = null; 
    }
  }
  

 int visit(Node root, int count) {
    if(root != null) {
      count++;
      return Math.max(visit(root.left, count), visit(root.right, count));
    }
    return count;
  }
  

  int visibleNodes(Node root) {
    return visit(root, 0);
  }
}