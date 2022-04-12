class Main {


  int sum(List<Integer> arr) {
    int sum =0;
    for (int v : arr) {
      sum += v;
    }
    return sum;
  }

  boolean balancedSplitExists(int[] arr) {

    Arrays.sort(arr);
    
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();
    
    int i=0;
    for (i=0; i<arr.length-1; i++) {
      left.add(arr[i]);
    }
    right.add(arr[i]);
    
    int leftSum = sum(left);
    int rightSum = sum(right);
    
    while (leftSum > rightSum) {
      int elem = left.pollLast();
      right.addFirst(elem);
      leftSum = (sum(left) - elem)/2;
      rightSum = (sum(right) + elem)/2;
    }
    
    if ((leftSum == rightSum) && (!right.getFirst().equals(left.getLast()))) {
      return true;
    }
    
    return false; 
  }

}