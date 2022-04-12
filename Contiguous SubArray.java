class Main {  

  int[] countSubarrays(int[] arr) {

    int[] res = new int[arr.length];
    int[] tmp = new int[arr.length];
    
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    
    for(int i=0; i<arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        res[i] += res[stack.pop()];
      }
      stack.push(i);
      res[i]++;
    }
    
    stack.clear();
    for(int i=arr.length-1; i>=0; i--){
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        res[i] += tmp[idx];
        tmp[i] += tmp[idx];
      }
      stack.push(i);
      tmp[i]++;
    }
    
    return res;
  }
}