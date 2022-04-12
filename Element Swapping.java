class Main {

  void swap(int[] arr, int a, int b) {
    int t = arr[a];
    arr[a] = arr[b];
    arr[b] = t;
  }
  int findMinIdx(int[] arr) {
    int min = arr[0];
    int idx = 0;
    for(int i=0; i<arr.length; i++) {
      if(min > arr[i]) {
        min = arr[i];
        idx = i;
      }
    }
    return idx;
  }
  
  int[] findMinArray(int[] arr, int k) {

    int i=0;
    int left = k;
    while(left > 0) {
    int m = findMinIdx(Arrays.copyOfRange(arr, i, i+k+1));
      if(m == 0 && left == k) {
        i++;
      } else if (m == 0 && left<k) {
        left=0;
      } else {
        swap(arr, m, m-1);
        left--;
        m--;
      }
    }
    
    return arr;
  }
}