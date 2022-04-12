class Main {
  
  
  int[] findPositions(int[] arr, int x) {

    int length = arr.length;
    x = Math.min(x, length);
    int[] result = new int[x];
    int idx = 0;
    
    for(int i=0; i<x; i++) {
      
      int count = Math.min(x, length-i);
      int maxIdx = idx;
      int max = arr[maxIdx];
      
      while (count > 0) {
        if (arr[idx] != -1) {
          if (max < arr[idx]) {
            max = arr[idx];
            maxIdx = idx;
          }
          if (arr[idx]>0) {
            arr[idx]--;
          }
          count--;
        }
        
        idx++;
        idx = idx % length;
      }
      
      arr[maxIdx] = -1;
      result[i] = maxIdx + 1;
    }
    
    return result;
  }
}