class Main {
  
  int findMaxDifference(int[] arr) {
    int max = 0;
    for(int j=0; j<arr.length; j++){
      int i = (j+1)%arr.length;
      if(max < arr[j]-arr[i]){
        max = Math.abs(arr[j]-arr[i]);
      }
    }

    return max;
  }
  
  int minOverallAwkwardness(int[] heights) {
    
    TreeSet<Integer> set = new TreeSet<>();
    for(int h: heights){
      set.add(h);
    }
    
    int[] res = new int[heights.length];
    int l = 0;
    int r = res.length-1;
    for(int i=0; i<res.length; i++) {
      int m = set.pollLast();
      if(i%2 != 0) {
         res[r] = m;
         r--;
      } else {
         res[l] = m;
         l++;
      }  
    }
    return findMaxDifference(res);
  }
}