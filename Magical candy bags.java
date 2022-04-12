class Main {
  
  int maxCandies(int[] arr, int k) {

    Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
    for(int val : arr) {
      heap.add(val);
    }
    
    int sum = 0;
    for(int i=0; i<k; i++) {
      int candies = heap.poll();
      heap.add(Math.floorDiv(candies, 2));
      sum += candies;
    }
    return sum;
  }
}
