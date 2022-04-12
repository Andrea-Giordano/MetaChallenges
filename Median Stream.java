class Main {  

  int[] findMedian(int[] arr) {

    int[] res = new int[arr.length];    

    Queue<Integer> maxq = new PriorityQueue<>((a,b) -> b-a);
    Queue<Integer> minq = new PriorityQueue<>();
    
    for (int i=0; i<arr.length; i++) {
      if ((i+1) % 2 == 0){
        maxq.add(arr[i]);
        minq.add(maxq.poll());
        res[i] = (maxq.peek() + minq.peek()) / 2;
      } else {
        minq.add(arr[i]);
        maxq.add(minq.poll());
        res[i] = maxq.peek();
      }
    }
    
    return res;
  }
}