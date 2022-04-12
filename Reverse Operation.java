class Main {
  
  class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
  }
  

  Node reverse(Node head) {
    Deque<Integer> subpart = new ArrayDeque<Integer>();

    Node newHead = new Node(0);
    Node newCurr = newHead;
    Node curr = head;
    
    while (curr != null) {
      if (curr.data % 2 != 0) { 
        newCurr.next = new Node(curr.data);
        newCurr = newCurr.next;
        
      } else {
        subpart.push(curr.data);
        
        while(curr.next!= null && curr.next.data % 2 == 0) {
          subpart.push(curr.next.data);
          curr = curr.next;
        }
        
        while(!subpart.isEmpty()) {
          newCurr.next = new Node(subpart.pop());
          newCurr = newCurr.next;
        }
      } 
      curr = curr.next;
    }
    
    return newHead.next;
  }
}