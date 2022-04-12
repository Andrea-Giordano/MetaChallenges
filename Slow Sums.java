class Main {
  
  int getTotalTime(int[] arr) {
    int penalties = 0;
    Arrays.sort(arr);
    
    for(int i=arr.length-1; i>0; i--) {
      int penalty = arr[i] + arr[i-1];
      penalties += penalty;
      arr[i-1] = penalty;
    }
        
    return penalties;    
  }
}